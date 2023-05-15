package caittastic.SimplyTorchBlocks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public class TorchBlockData{
  private final String colourName ;
  private final TagKey<Item> dye;

  public TorchBlockData(String colourName, TagKey<Item> dye){
    this.colourName = colourName;
    this.dye = dye;
  }

  public TagKey<Item> getDyeTag(){
    return this.dye;
  }

  public String getDyeName(){
    return this.colourName;
  }
}
