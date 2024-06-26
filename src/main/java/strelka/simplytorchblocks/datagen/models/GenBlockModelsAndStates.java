package strelka.simplytorchblocks.datagen.models;

import strelka.simplytorchblocks.ModBlocksAndItems;
import strelka.simplytorchblocks.SimplyTorchBlocks;
import strelka.simplytorchblocks.TorchBlockData;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GenBlockModelsAndStates extends BlockStateProvider{
  public GenBlockModelsAndStates(PackOutput gen, ExistingFileHelper helper, String modid){
    super(gen, modid, helper);
  }

  @Override
  protected void registerStatesAndModels(){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      simpleBlock(ModBlocksAndItems.TORCH_BLOCK_MAP.get(data.getDyeName()).get()); //register block model
    }
  }
}

