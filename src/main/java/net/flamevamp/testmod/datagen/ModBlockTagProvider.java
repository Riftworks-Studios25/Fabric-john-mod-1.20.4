package net.flamevamp.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flamevamp.testmod.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.JOHN_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.JOHNSTONE)
                .add(ModBlocks.JOHNSTONE_STAIRS)
                .add(ModBlocks.JOHNSTONE_SLAB)
                .add(ModBlocks.JOHNSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.JOHNSTONE)
                .add(ModBlocks.JOHNSTONE_STAIRS)
                .add(ModBlocks.JOHNSTONE_SLAB)
                .add(ModBlocks.JOHNSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.JOHNSTONE_WALL);
    }

}

