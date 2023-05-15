package caittastic.SimplyTorchBlocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags{
  public static class Items{
    public static final TagKey<Item> TORCH_BLOCKS = ItemTags.create(new ResourceLocation(SimplyTorchBlocks.MOD_ID, "torch_blocks"));
  }
}
