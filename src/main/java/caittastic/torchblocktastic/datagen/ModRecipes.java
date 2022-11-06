package caittastic.torchblocktastic.datagen;

import caittastic.torchblocktastic.TorchBlocktastic;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        //torch block recipe
        ShapedRecipeBuilder.shaped(TorchBlocktastic.TORCH_BLOCK_MAP.get("white").get(), 4)
                .define('s', Ingredient.of(Items.STICK))
                .define('p', Ingredient.of(Items.PAPER))
                .define('t', Ingredient.of(Blocks.TORCH))
                .pattern("sps")
                .pattern("ptp")
                .pattern("sps")
                .unlockedBy("has_torch", has(Blocks.TORCH))
                .save(consumer);
        //8 block dyed block
        buildTorchDyeRecipe(consumer, "black", Items.BLACK_DYE);
        buildTorchDyeRecipe(consumer, "brown", Items.BROWN_DYE);
        buildTorchDyeRecipe(consumer, "blue", Items.BLUE_DYE);
        buildTorchDyeRecipe(consumer, "cyan", Items.CYAN_DYE);
        buildTorchDyeRecipe(consumer, "gray", Items.GRAY_DYE);
        buildTorchDyeRecipe(consumer, "green", Items.GREEN_DYE);
        buildTorchDyeRecipe(consumer, "light_blue", Items.LIGHT_BLUE_DYE);
        buildTorchDyeRecipe(consumer, "light_gray", Items.LIGHT_GRAY_DYE);
        buildTorchDyeRecipe(consumer, "lime", Items.LIME_DYE);
        buildTorchDyeRecipe(consumer, "magenta", Items.MAGENTA_DYE);
        buildTorchDyeRecipe(consumer, "orange", Items.ORANGE_DYE);
        buildTorchDyeRecipe(consumer, "pink", Items.PINK_DYE);
        buildTorchDyeRecipe(consumer, "purple", Items.PURPLE_DYE);
        buildTorchDyeRecipe(consumer, "red", Items.RED_DYE);
        buildTorchDyeRecipe(consumer, "white", Items.WHITE_DYE);
        buildTorchDyeRecipe(consumer, "yellow", Items.YELLOW_DYE);
    }

    private void buildTorchDyeRecipe(Consumer<FinishedRecipe> consumer, String torchBlockKey, Item dyeItem) {
        ShapedRecipeBuilder.shaped(TorchBlocktastic.TORCH_BLOCK_MAP.get(torchBlockKey).get(), 8)
                .define('d', Ingredient.of(dyeItem))
                .define('#', Ingredient.of(TorchBlocktastic.TORCH_BLOCK_MAP.get("white").get()))
                .pattern("###")
                .pattern("#d#")
                .pattern("###")
                .unlockedBy("has_torch", has(Blocks.TORCH))
                .save(consumer);
    }
}

