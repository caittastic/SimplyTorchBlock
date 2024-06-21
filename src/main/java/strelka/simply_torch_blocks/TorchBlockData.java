package strelka.simply_torch_blocks;

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
