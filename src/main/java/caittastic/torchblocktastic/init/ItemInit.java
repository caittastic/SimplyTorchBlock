package caittastic.torchblocktastic.init;


import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;
import static caittastic.torchblocktastic.TorchBlocktastic.TORCH_BLOCK;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    //function that registers items
    private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    };
}
