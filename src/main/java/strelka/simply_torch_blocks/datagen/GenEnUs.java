package strelka.simply_torch_blocks.datagen;

import strelka.simply_torch_blocks.ModBlocksAndItems;
import strelka.simply_torch_blocks.SimplyTorchBlocks;
import strelka.simply_torch_blocks.TorchBlockData;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class GenEnUs extends LanguageProvider{
  public GenEnUs(PackOutput gen, String locale, String modid){
    super(gen, modid, locale);
  }

  @Override
  protected void addTranslations(){
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      String dyeName = data.getDyeName();
      add(ModBlocksAndItems.TORCH_BLOCK_MAP.get(dyeName).get(), capitalizeFully(dyeName.replace("_", " ")) + " Torch Block");
    }
    add("creative_tab.torch_block_tab", "Simply Torch Blocks");
  }
}
