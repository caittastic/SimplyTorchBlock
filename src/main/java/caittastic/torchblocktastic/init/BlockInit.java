package caittastic.torchblocktastic.init;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
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

import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;
import static caittastic.torchblocktastic.TorchBlocktastic.TORCH_BLOCK;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    //creates the white torch block
    public static final RegistryObject<Block> WHITE_TORCH_BLOCK = register("white_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));





    //function that registers blocks
    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name,block);
    };
    //function that registers items
    private static <T extends Block>RegistryObject<T> register(final String name, final Supplier<? extends T> block,
            Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name,block);
        ITEMS.register(name,item.apply(obj));
        return obj;
    };


}
