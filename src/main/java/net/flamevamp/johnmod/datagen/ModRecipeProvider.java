package net.flamevamp.johnmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.flamevamp.johnmod.block.ModBlocks;
import net.flamevamp.johnmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.JOHN_FRAME, 1)
                .pattern("PEP")
                .pattern("EJE")
                .pattern("PEP")
                .input('J', ModBlocks.JOHN_BLOCK)
                .input('P', Items.BLAZE_POWDER)
                .input('E', Items.EMERALD)
                .criterion(hasItem(ModBlocks.JOHN_BLOCK), conditionsFromItem(ModBlocks.JOHN_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.JOHN_FRAME)));


        offerSmelting(exporter, NOSE_SMELTABLES, RecipeCategory.FOOD,
                ModItems.COOKED_NOSE, 0.7f, 400, "nose");

        createStairsRecipe(ModBlocks.JOHNSTONE_STAIRS, Ingredient.ofItems(ModBlocks.JOHNSTONE))
                .criterion(hasItem(ModBlocks.JOHNSTONE), conditionsFromItem(ModBlocks.JOHNSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.JOHNSTONE_STAIRS)));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JOHNSTONE_SLAB, ModBlocks.JOHNSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JOHNSTONE_WALL, ModBlocks.JOHNSTONE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JOHNSTONE_STAIRS,
                ModBlocks.JOHNSTONE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JOHNSTONE_SLAB,
                ModBlocks.JOHNSTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JOHNSTONE_WALL,
                ModBlocks.JOHNSTONE, 1);
    }
}