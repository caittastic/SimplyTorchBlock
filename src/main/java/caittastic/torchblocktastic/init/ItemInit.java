package caittastic.torchblocktastic.init;

import com.google.common.base.Supplier;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;
import static caittastic.torchblocktastic.TorchBlocktastic.TORCH_BLOCK;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    //adds our item
    public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",() -> new Item(new Item.Properties().tab(TORCH_BLOCK)));

    //function that registers items
    private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    };
}
