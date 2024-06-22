package strelka.simplytorchblocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimplyTorchBlocks.MOD_ID)
public class SimplyTorchBlocks{
    public static final String MOD_ID = "simplytorchblocks"; //a string that contains our modid, accessable anywhere
    public static final TagKey<Item> TORCH_BLOCK_TAG = ItemTags.create(new ResourceLocation(SimplyTorchBlocks.MOD_ID, "torch_blocks"));
    public static final TorchBlockData[] TORCH_BLOCK_DATA = {
        new TorchBlockData("white", Tags.Items.DYES_WHITE),
        new TorchBlockData("light_gray", Tags.Items.DYES_LIGHT_GRAY),
        new TorchBlockData("gray", Tags.Items.DYES_GRAY),
        new TorchBlockData("black", Tags.Items.DYES_BLACK),
        new TorchBlockData("brown", Tags.Items.DYES_BROWN),
        new TorchBlockData("red", Tags.Items.DYES_RED),
        new TorchBlockData("orange", Tags.Items.DYES_ORANGE),
        new TorchBlockData("yellow", Tags.Items.DYES_YELLOW),
        new TorchBlockData("lime", Tags.Items.DYES_LIME),
        new TorchBlockData("green", Tags.Items.DYES_GREEN),
        new TorchBlockData("cyan", Tags.Items.DYES_GREEN),
        new TorchBlockData("light_blue", Tags.Items.DYES_LIGHT_BLUE),
        new TorchBlockData("blue", Tags.Items.DYES_BLUE),
        new TorchBlockData("purple", Tags.Items.DYES_PURPLE),
        new TorchBlockData("magenta", Tags.Items.DYES_MAGENTA),
        new TorchBlockData("pink", Tags.Items.DYES_PINK),
    };

    public SimplyTorchBlocks(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); //the bus for registries
        ModBlocksAndItems.BLOCKS.register(bus); //register block registry
        ModBlocksAndItems.ITEMS.register(bus); //register item registry
        TABS.register(bus);
        MinecraftForge.EVENT_BUS.register(this); // Register ourselves for server and other game events we are interested in
    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static RegistryObject<CreativeModeTab> TORCH_BLOCK_TAB = TABS.register("torch_block_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("creative_tab.torch_block_tab"))
        .icon(() -> new ItemStack(ModBlocksAndItems.TORCH_BLOCK_MAP.get("white").get()))
        .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
        .displayItems((featureFlags, output) -> {
            for ( RegistryObject<Block> torchBlock : ModBlocksAndItems.TORCH_BLOCK_MAP.values()) {
                output.accept(torchBlock.get());
            }
        })
        .build());
}
