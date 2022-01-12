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

import java.lang.reflect.Array;

import static caittastic.torchblocktastic.TorchBlocktastic.MOD_ID;
import static caittastic.torchblocktastic.TorchBlocktastic.TORCH_BLOCK;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
    //public static final String[] colours = {"black", "blue", "cyan", "green" ,"grey", "light_blue", "light_green", "light_grey", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};




    //creates the black torch block
    public static final RegistryObject<Block> BLACK_TORCH_BLOCK = register("black_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the blue torch block
    public static final RegistryObject<Block> BLUE_TORCH_BLOCK = register("blue_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the cyan torch block
    public static final RegistryObject<Block> CYAN_TORCH_BLOCK = register("cyan_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the green torch block
    public static final RegistryObject<Block> GREEN_TORCH_BLOCK = register("green_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the grey torch block
    public static final RegistryObject<Block> GREY_TORCH_BLOCK = register("grey_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the light blue torch block
    public static final RegistryObject<Block> LIGHT_BLUE_TORCH_BLOCK = register("light_blue_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the light green torch block
    public static final RegistryObject<Block> LIGHT_GREEN_TORCH_BLOCK = register("light_green_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the light grey torch block
    public static final RegistryObject<Block> LIGHT_GREY_TORCH_BLOCK = register("light_grey_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the magenta torch block
    public static final RegistryObject<Block> MAGENTA_TORCH_BLOCK = register("magenta_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the orange torch block
    public static final RegistryObject<Block> ORANGE_TORCH_BLOCK = register("orange_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the pink torch block
    public static final RegistryObject<Block> PINK_TORCH_BLOCK = register("pink_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the purple torch block
    public static final RegistryObject<Block> PURPLE_TORCH_BLOCK = register("purple_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the red torch block
        public static final RegistryObject<Block> RED_TORCH_BLOCK = register("red_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the white torch block
    public static final RegistryObject<Block> WHITE_TORCH_BLOCK = register("white_torch_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).strength(0.3f).sound(SoundType.WOOL).lightLevel((p_50870_) -> { return 14; })),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TORCH_BLOCK) ));

    //creates the yellow torch block
        public static final RegistryObject<Block> YELLOW_TORCH_BLOCK = register("yellow_torch_block",
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
