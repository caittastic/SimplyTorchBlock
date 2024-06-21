package caittastic.SimplyTorchBlocks.datagen;

import caittastic.SimplyTorchBlocks.ModBlocksAndItems;
import caittastic.SimplyTorchBlocks.SimplyTorchBlocks;
import caittastic.SimplyTorchBlocks.TorchBlockData;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class GenItemTags extends ItemTagsProvider{

  public GenItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> blockFuture, ExistingFileHelper existingFileHelper, String modID){
    super(packOutput, future, blockFuture, modID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.@NotNull Provider provider){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      this.tag(SimplyTorchBlocks.TORCH_BLOCK_TAG).add(ModBlocksAndItems.TORCH_BLOCK_MAP.get(data.getDyeName()).get().asItem());
    }
  }
}