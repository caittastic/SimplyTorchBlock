package caittastic.SimplyTorchBlocks.datagen;

import caittastic.SimplyTorchBlocks.ModBlocksAnditems;
import caittastic.SimplyTorchBlocks.SimplyTorchBlocks;
import caittastic.SimplyTorchBlocks.TorchBlockData;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GenBlockTags extends BlockTagsProvider{
  public GenBlockTags(PackOutput generator, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper helper, String modid){
    super(generator, lookupProvider, modid, helper);
  }

  @Override
  protected void addTags(HolderLookup.@NotNull Provider provider){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocksAnditems.TORCH_BLOCK_MAP.get(data.getDyeName()).get());
    }
  }
}