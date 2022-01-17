package caittastic.torchblocktastic.init;


import caittastic.torchblocktastic.init.custom.CustomTorchBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static caittastic.torchblocktastic.TorchBlocktastic.*;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
    //a list of all the supported colours to hopefully some day automatically generate blocks
    public static final Map<String,RegistryObject<Block>> TORCH_BLOCK_BY_COLOUR = new HashMap<>();

    static{
        for(String cycle:colours){
            TORCH_BLOCK_BY_COLOUR.put(cycle, register(cycle + "_torch_block",
                    () -> new CustomTorchBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> 14 )),
                    object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) )));
        }
    }

    //function that registers blocks
    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name,block);
    };
    //function that registers items
    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name,block);
        ITEMS.register(name,item.apply(obj));
        return obj;
    };
}
