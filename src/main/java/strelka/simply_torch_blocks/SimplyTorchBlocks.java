package strelka.simply_torch_blocks;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        MinecraftForge.EVENT_BUS.register(this); // Register ourselves for server and other game events we are interested in
        bus.addListener(this::addTabs); //registers our creative mode tab
    }

    private void addTabs(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == ModTab.TORCH_BLOCK_TAB){
            for(TorchBlockData data: TORCH_BLOCK_DATA){
                event.accept(ModBlocksAndItems.TORCH_BLOCK_MAP.get(data.getDyeName()).get());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = SimplyTorchBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModTab{
        public static CreativeModeTab TORCH_BLOCK_TAB;

        @SubscribeEvent
        public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
            TORCH_BLOCK_TAB = event.registerCreativeModeTab(new ResourceLocation(SimplyTorchBlocks.MOD_ID, "torch_block_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocksAndItems.TORCH_BLOCK_MAP.get("white").get())
                ).title(Component.translatable("creative_tab.torch_block_tab")));
        }
    }


}
