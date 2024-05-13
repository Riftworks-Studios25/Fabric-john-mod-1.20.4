package net.flamevamp.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.flamevamp.testmod.block.ModBlocks;
import net.flamevamp.testmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JOHN_BLOCK);
        BlockStateModelGenerator.BlockTexturePool johnstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JOHNSTONE);

        johnstonePool.stairs(ModBlocks.JOHNSTONE_STAIRS);
        johnstonePool.slab(ModBlocks.JOHNSTONE_SLAB);
        johnstonePool.wall(ModBlocks.JOHNSTONE_WALL);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.JOHN_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_NOSE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_NOSE, Models.GENERATED);

        itemModelGenerator.register(ModItems.NOSE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),
                        Optional.empty()));
        itemModelGenerator.register(ModItems.WITCH_NOSE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),
                        Optional.empty()));
    }
}
