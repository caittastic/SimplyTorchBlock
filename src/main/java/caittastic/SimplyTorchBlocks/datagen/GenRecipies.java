package caittastic.SimplyTorchBlocks.datagen;

import caittastic.SimplyTorchBlocks.ModBlocksAnditems;
import caittastic.SimplyTorchBlocks.ModTags;
import caittastic.SimplyTorchBlocks.SimplyTorchBlocks;
import caittastic.SimplyTorchBlocks.TorchBlockData;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class GenRecipies extends RecipeProvider{
  public GenRecipies(PackOutput generatorIn){super(generatorIn);}

  @Override
  protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer){
    //gen white torch block
    ShapedRecipeBuilder
            .shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocksAnditems.TORCH_BLOCK_MAP.get("white").get(), 4)
            .define('s', Ingredient.of(Items.STICK))
            .define('t', Ingredient.of(Items.TORCH))
            .define('p', Ingredient.of(Items.PAPER))
            .pattern("sps")
            .pattern("ptp")
            .pattern("sps")
            .unlockedBy(getHasName(Items.TORCH), has(Items.TORCH))
            .save(consumer);

    //universal dying torch block recipe
    for(TorchBlockData data: SimplyTorchBlocks.TORCH_BLOCK_DATA){
      Block torchBlock = ModBlocksAnditems.TORCH_BLOCK_MAP.get(data.getDyeName()).get();
      ShapedRecipeBuilder
              .shaped(RecipeCategory.BUILDING_BLOCKS, torchBlock, 8)
              .define('t', Ingredient.of(ModTags.Items.TORCH_BLOCKS))
              .define('d', Ingredient.of(data.getDyeTag()))
              .pattern("ttt")
              .pattern("tdt")
              .pattern("ttt")
              .unlockedBy(getHasName(Items.TORCH), has(Items.TORCH))
              .unlockedBy("has_torch_block", has(ModTags.Items.TORCH_BLOCKS))
              .save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(torchBlock.asItem())).getPath() + "_from_dying");
    }
  }
}

