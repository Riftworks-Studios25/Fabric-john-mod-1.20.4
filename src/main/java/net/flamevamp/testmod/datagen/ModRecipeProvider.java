package net.flamevamp.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.flamevamp.testmod.block.ModBlocks;
import net.flamevamp.testmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import org.apache.commons.compress.harmony.pack200.NewAttribute;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemConvertible> NOSE_SMELTABLES = List.of(ModItems.RAW_NOSE);

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.JOHN_SHARD, RecipeCategory.DECORATIONS, ModBlocks.JOHN_BLOCK);

        offerSmelting(exporter, NOSE_SMELTABLES, RecipeCategory.FOOD,
                ModItems.COOKED_NOSE, 0.7f, 400, "nose");
    }
}