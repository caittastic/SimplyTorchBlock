package caittastic.SimplyTorchBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocksAnditems{
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplyTorchBlocks.MOD_ID); //block registry
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplyTorchBlocks.MOD_ID); //item registry
  public static final Map<String, RegistryObject<Block>> TORCH_BLOCK_MAP = new HashMap<>(); //map that contains torch blocks mapped to colours

  static{
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      TORCH_BLOCK_MAP.put(data.getDyeName(), registerBlockWithBlockItem(data.getDyeName() + "_torch_block",
              () -> new TorchBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(0.3f).lightLevel((blockState) -> 14))));
    }
  }

  //registers a block and block item
  public static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String name, Supplier<T> block){
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    return toReturn;
  }

}
