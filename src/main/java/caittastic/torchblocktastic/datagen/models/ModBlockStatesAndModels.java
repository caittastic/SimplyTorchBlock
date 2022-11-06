package caittastic.torchblocktastic.datagen.models;

import caittastic.torchblocktastic.TorchBlocktastic;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static caittastic.torchblocktastic.TorchBlocktastic.COLOURS;
import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;

public class ModBlockStatesAndModels extends BlockStateProvider {
    public ModBlockStatesAndModels(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (String colour : COLOURS) {
            simpleBlock(TorchBlocktastic.TORCH_BLOCK_MAP.get(colour).get()); //register block model
        }
    }
}

