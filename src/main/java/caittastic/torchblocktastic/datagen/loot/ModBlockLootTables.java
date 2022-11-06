package caittastic.torchblocktastic.datagen.loot;

import caittastic.torchblocktastic.TorchBlocktastic;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import static caittastic.torchblocktastic.TorchBlocktastic.COLOURS;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TorchBlocktastic.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void addTables() {
        for (String colour : COLOURS) {
            this.dropSelf(TorchBlocktastic.TORCH_BLOCK_MAP.get(colour).get());
        }
    }
}
