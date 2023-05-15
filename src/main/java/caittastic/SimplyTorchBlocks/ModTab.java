package caittastic.SimplyTorchBlocks;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimplyTorchBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTab{
  public static CreativeModeTab TORCH_BLOCK_TAB;

  @SubscribeEvent
  public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
    TORCH_BLOCK_TAB = event.registerCreativeModeTab(new ResourceLocation(SimplyTorchBlocks.MOD_ID, "torch_block_tab"),
            builder -> builder.icon(() -> new ItemStack(ModBlocksAnditems.TORCH_BLOCK_MAP.get("white").get())
            ).title(Component.translatable("creative_tab.torch_block_tab")));
  }
}
