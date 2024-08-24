package net.flamevamp.johnmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.flamevamp.johnmod.block.ModBlocks;
import net.flamevamp.johnmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider implements DataProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemConvertible> NOSE_SMELTABLES = List.of(ModItems.RAW_NOSE);

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.JOHN_SHARD, RecipeCategory.DECORATIONS, ModBlocks.JOHN_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHARD_AND_POWDER, 1)
                .input(ModItems.JOHN_SHARD)
                .input(Items.BLAZE_POWDER)
                .criterion(hasItem(ModItems.JOHN_SHARD), conditionsFromItem(ModItems.JOHN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARD_AND_POWDER)));

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModItems.JOHN_NOSE, ModItems.JOHN_NOSE_FRAGMENT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.JOHN_FRAME, 1)
                .pattern("PEP")
                .pattern("EJE")
                .pattern("PEP")
                .input('J', Blocks.EMERALD_BLOCK)
                .input('P', Items.BLAZE_POWDER)
                .input('E', ModItems.JOHN_SHARD)
                .criterion(hasItem(ModItems.JOHN_SHARD), conditionsFromItem(ModItems.JOHN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.JOHN_FRAME)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JOHN_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("DSD")
                .pattern("DJD")
                .pattern("DDD")
                .input('J', ModBlocks.JOHN_BLOCK)
                .input('D', Items.DIAMOND)
                .input('S', ModItems.JOHN_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.JOHN_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.JOHN_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JOHN_UPGRADE_SMITHING_TEMPLATE)));

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