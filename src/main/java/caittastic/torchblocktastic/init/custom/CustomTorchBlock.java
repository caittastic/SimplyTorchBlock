package caittastic.torchblocktastic.init.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.sounds.SoundEvent;
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
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import static caittastic.torchblocktastic.init.BlockInit.TORCH_BLOCK_BY_COLOUR;

public class CustomTorchBlock extends Block {
    public CustomTorchBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {

        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {

        return 30;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemInHand = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        if(pHand == InteractionHand.MAIN_HAND){
            if(itemInHand.is(Items.POTION) ) {
                if (PotionUtils.getPotion(itemInHand) == Potions.WATER) {
                    if(pState != TORCH_BLOCK_BY_COLOUR.get("white").get().defaultBlockState()){

                        pLevel.playSound(pPlayer, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 0.5F, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);

                        if (pLevel.isClientSide()) {
                            return InteractionResult.sidedSuccess(true);
                        }
                        pLevel.setBlock(pPos, TORCH_BLOCK_BY_COLOUR.get("white").get().defaultBlockState(), 3);
                        return InteractionResult.sidedSuccess(false);
                    }
                }
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
