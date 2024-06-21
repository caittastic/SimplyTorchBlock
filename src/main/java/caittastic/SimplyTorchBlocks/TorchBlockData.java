package caittastic.SimplyTorchBlocks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public record TorchBlockData(String colourName, TagKey<Item> dye){

  public TagKey<Item> getDyeTag(){
    return this.dye;
  }

  public String getDyeName(){
    return this.colourName;
  }
}
