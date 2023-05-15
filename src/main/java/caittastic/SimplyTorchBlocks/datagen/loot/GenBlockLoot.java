package caittastic.SimplyTorchBlocks.datagen.loot;

import caittastic.SimplyTorchBlocks.ModBlocksAnditems;
import caittastic.SimplyTorchBlocks.SimplyTorchBlocks;
import caittastic.SimplyTorchBlocks.TorchBlockData;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class GenBlockLoot extends BlockLootSubProvider{
  public GenBlockLoot(){
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  }

  @Override
  protected void generate(){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      this.dropSelf(ModBlocksAnditems.TORCH_BLOCK_MAP.get(data.getDyeName()).get());
    }
  }

  @Override
  protected @NotNull Iterable<Block> getKnownBlocks(){
    return ModBlocksAnditems.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
  }
}
