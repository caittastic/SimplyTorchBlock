package caittastic.SimplyTorchBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class TorchBlock extends Block {
    public TorchBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override // makes our block flamable
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override //gets the speed at wich our block spreads fire
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }

    @Override //result of right clicking on the block
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos bPos, Player player, @NotNull InteractionHand iHand, @NotNull BlockHitResult bHitResult) {
        InteractionHand mainHand = InteractionHand.MAIN_HAND; //main hand
        ItemStack itemInMainHand = player.getItemInHand(mainHand); //item in main hand

        BlockState whiteTorchBlockBlockState = ModBlocksAnditems.TORCH_BLOCK_MAP.get("white").get().defaultBlockState(); //the default block state of the white torch block
        //is the interaction hand the main hand and is the item in main hand a potion and is self a white torch block and is the held potion in main hand water
        if(iHand == mainHand && itemInMainHand.is(Items.POTION) && PotionUtils.getPotion(itemInMainHand) == Potions.WATER && blockState != whiteTorchBlockBlockState){
            //play cleaning noise
            level.playSound(player, bPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 0.5F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            //set block to white torch block
            level.setBlock(bPos, whiteTorchBlockBlockState, 3);
            //if client side, return successful interaction
            if(level.isClientSide()){
                return InteractionResult.sidedSuccess(true);
            }
            return InteractionResult.sidedSuccess(false);
        }
        return super.use(blockState, level, bPos, player, iHand, bHitResult);
    }
}
