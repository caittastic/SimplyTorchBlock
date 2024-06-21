package caittastic.SimplyTorchBlocks.datagen.Models;

import caittastic.SimplyTorchBlocks.ModBlocksAndItems;
import caittastic.SimplyTorchBlocks.SimplyTorchBlocks;
import caittastic.SimplyTorchBlocks.TorchBlockData;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class GenItemModels extends ItemModelProvider{

  public GenItemModels(PackOutput generator, ExistingFileHelper existingFileHelper){
    super(generator, SimplyTorchBlocks.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels(){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      withExistingParent(
              Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(ModBlocksAndItems.TORCH_BLOCK_MAP.get(data.getDyeName()).get())).toString(),
              modLoc("block/" + data.getDyeName() + "_torch_block"));
    }
  }

}

