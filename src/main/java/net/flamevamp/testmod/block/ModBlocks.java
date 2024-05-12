package net.flamevamp.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.flamevamp.testmod.TestMod;
import net.minecraft.block.*;
import net.minecraft.client.gl.Uniform;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block JOHN_BLOCK = registerBlock("john_block",
            new Block(FabricBlockSettings.copyOf(Blocks.SCULK).strength(1f)));

    public static final Block JOHNSTONE = registerBlock("johnstone",
            new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).strength(3f)));
    public static final Block JOHNSTONE_STAIRS = registerBlock("johnstone_stairs",
            new StairsBlock(ModBlocks.JOHNSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).strength(3f)));
    public static final Block JOHNSTONE_SLAB = registerBlock("johnstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).strength(3f)));
    public static final Block JOHNSTONE_WALL = registerBlock("johnstone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).strength(3f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
    }
}
