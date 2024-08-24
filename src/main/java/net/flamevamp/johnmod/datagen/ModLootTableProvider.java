package net.flamevamp.johnmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.flamevamp.johnmod.block.ModBlocks;
import net.flamevamp.johnmod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.JOHN_BLOCK);
        addDrop(ModBlocks.JOHN_FRAME);
        addDrop(ModBlocks.JOHNSTONE);
        addDrop(ModBlocks.JOHNSTONE_STAIRS);
        addDrop(ModBlocks.JOHNSTONE_WALL);

        addDrop(ModBlocks.JOHNSTONE_SLAB, slabDrops(ModBlocks.JOHNSTONE_SLAB));
    }


}
