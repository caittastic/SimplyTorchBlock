package strelka.simply_torch_blocks.datagen;

import strelka.simply_torch_blocks.ModBlocksAndItems;
import strelka.simply_torch_blocks.SimplyTorchBlocks;
import strelka.simply_torch_blocks.TorchBlockData;
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
            .shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocksAndItems.TORCH_BLOCK_MAP.get("white").get(), 4)
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
      Block torchBlock = ModBlocksAndItems.TORCH_BLOCK_MAP.get(data.getDyeName()).get();
      ShapedRecipeBuilder
              .shaped(RecipeCategory.BUILDING_BLOCKS, torchBlock, 8)
              .define('t', Ingredient.of(SimplyTorchBlocks.TORCH_BLOCK_TAG))
              .define('d', Ingredient.of(data.getDyeTag()))
              .pattern("ttt")
              .pattern("tdt")
              .pattern("ttt")
              .unlockedBy(getHasName(Items.TORCH), has(Items.TORCH))
              .unlockedBy("has_torch_block", has(SimplyTorchBlocks.TORCH_BLOCK_TAG))
              .save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(torchBlock.asItem())).getPath() + "_from_dying");
    }
  }
}

