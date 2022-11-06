package caittastic.torchblocktastic;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TorchBlocktastic.MOD_ID)
public class TorchBlocktastic {
    /*----------------------------------------------- variables -----------------------------------------------*/
    public static final String MOD_ID = "torchblocktastic"; //a string that contains our modid, accessable anywhere
    public static final String[] COLOURS = {"black", "brown", "blue", "cyan", "gray", "green", "light_blue", "light_gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"}; //all the colours our mod works with
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID); //block registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID); //item registry
    public static final Map<String, RegistryObject<Block>> TORCH_BLOCK_MAP = new HashMap<>(); //map that contains torch blocks mapped to colours
    /*----------------------------------------------- mod setup and running -----------------------------------------------*/
    public TorchBlocktastic() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); //the bus for registries
        BLOCKS.register(bus); //register block registry
        ITEMS.register(bus); //register item registry
        MinecraftForge.EVENT_BUS.register(this); // Register ourselves for server and other game events we are interested in
    }

    /*----------------------------------------------- tab -----------------------------------------------*/
    public static final CreativeModeTab TORCH_BLOCK_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(TORCH_BLOCK_MAP.get("white").get());
        }
    };

    /*----------------------------------------------- mod block and item registering -----------------------------------------------*/
    //for every colour, create a new torch block and add it to the hashmap mapped to the colour
    static {
        for (String colour : COLOURS) {
            TORCH_BLOCK_MAP.put(colour, registerBlockWithBlockItem(colour + "_torch_block", () -> new ModTorchBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(0.3f).lightLevel((p_50870_) -> 14)), TORCH_BLOCK_TAB));
        }
    }

    //registers a block and block item
    public static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(tab)));
        return toReturn;
    }
}
