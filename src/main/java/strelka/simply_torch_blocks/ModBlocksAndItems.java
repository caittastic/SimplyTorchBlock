package strelka.simply_torch_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocksAndItems{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplyTorchBlocks.MOD_ID); //block registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplyTorchBlocks.MOD_ID); //item registry
    public static final Map<String, RegistryObject<Block>> TORCH_BLOCK_MAP = new HashMap<>(); //map that contains torch blocks mapped to colours

    static{
        for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
            TORCH_BLOCK_MAP.put(
                data.getDyeName(),
                registerBlockWithBlockItem(
                    data.getDyeName() + "_torch_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(0.3f).lightLevel((blockState) -> 14)){
                        @Override
                        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face){return 60;} // makes our block flamable

                        @Override
                        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face){return 30;} //gets the speed at wich our block spreads fire

                        //result of right clicking on the block
                        @Override
                        public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos bPos, Player player, @NotNull InteractionHand iHand, @NotNull BlockHitResult bHitResult){
                            ItemStack itemInMainHand = player.getItemInHand(InteractionHand.MAIN_HAND); //item in main hand
                            BlockState whiteTorchBlockBlockState = ModBlocksAndItems.TORCH_BLOCK_MAP.get("white").get().defaultBlockState(); //the default block state of the white torch block
                            //is the interaction hand the main hand and is the item in main hand a potion and is self a white torch block and is the held potion in main hand water
                            if(iHand == InteractionHand.MAIN_HAND && itemInMainHand.is(Items.POTION) && PotionUtils.getPotion(itemInMainHand) == Potions.WATER && blockState != whiteTorchBlockBlockState){
                                //play cleaning noise
                                level.playSound(player, bPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 0.5F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                                //set block to white torch block
                                level.setBlock(bPos, whiteTorchBlockBlockState, 3);
                                //if client side, return successful interaction
                                if(level.isClientSide()) return InteractionResult.sidedSuccess(true);
                                return InteractionResult.sidedSuccess(false);
                            }
                            return super.use(blockState, level, bPos, player, iHand, bHitResult);
                        }
                    }
                )
            );
        }
    }

    //registers a block and block item
    public static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

}
