package net.flamevamp.johnmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.flamevamp.johnmod.JohnMod;
import net.minecraft.block.*;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block JOHN_BLOCK = registerBlock("john_block",
            new Block(FabricBlockSettings.copyOf(Blocks.SCULK).strength(1.5f)));

    public static final Block JOHN_FRAME = registerBlock("john_frame",
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
        return Registry.register(Registries.BLOCK, new Identifier(JohnMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(JohnMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        JohnMod.LOGGER.info("Registering ModBlocks for " + JohnMod.MOD_ID);
    }
}