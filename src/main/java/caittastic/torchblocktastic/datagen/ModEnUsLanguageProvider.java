package caittastic.torchblocktastic.datagen;

import caittastic.torchblocktastic.TorchBlocktastic;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static caittastic.torchblocktastic.TorchBlocktastic.COLOURS;
import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;
import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class ModEnUsLanguageProvider extends LanguageProvider {
    public ModEnUsLanguageProvider(DataGenerator gen, String locale) {
        super(gen, MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        for (String colour : COLOURS) {
            add(TorchBlocktastic.TORCH_BLOCK_MAP.get(colour).get(), capitalizeFully(colour.replace("_", " ")) + " Torch Block");//planks
        }
        add("itemGroup." + TorchBlocktastic.TORCH_BLOCK_TAB.getRecipeFolderName(), "Simply Torch Block");
    }
}
