package strelka.simply_torch_blocks.datagen;

import strelka.simply_torch_blocks.SimplyTorchBlocks;
import strelka.simply_torch_blocks.datagen.models.GenBlockModelsAndStates;
import strelka.simply_torch_blocks.datagen.models.GenItemModels;
import strelka.simply_torch_blocks.datagen.loot.GenLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SimplyTorchBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators{
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event){
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
    ExistingFileHelper fileHelper = event.getExistingFileHelper();
    String modId = SimplyTorchBlocks.MOD_ID;
    GenBlockTags blockTags = new GenBlockTags(packOutput, lookupProvider, fileHelper, modId);

    /*     client     */
    boolean isClient = event.includeClient();
    generator.addProvider(isClient, new GenBlockModelsAndStates(packOutput, fileHelper, modId));
    generator.addProvider(isClient, new GenItemModels(packOutput, fileHelper));
    generator.addProvider(isClient, new GenEnUs(packOutput, "en_us", modId));

    /*     server     */
    boolean isServer = event.includeServer();
    generator.addProvider(isServer, new GenRecipies(packOutput));
    generator.addProvider(isServer, GenLootTables.create(packOutput));
    generator.addProvider(isServer, blockTags);
    generator.addProvider(isServer, new GenItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper, modId));
  }
}
