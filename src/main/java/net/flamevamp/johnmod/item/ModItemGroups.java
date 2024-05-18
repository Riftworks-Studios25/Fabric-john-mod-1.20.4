package net.flamevamp.johnmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JOHN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JohnMod.MOD_ID, "john"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.john"))
                    .icon(() -> new ItemStack(ModItems.JOHN_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.JOHN_SHARD);
                        entries.add(ModItems.JOHN_NOSE);
                        entries.add(ModItems.JOHN_NOSE_FRAGMENT);

                        entries.add(ModItems.RAW_NOSE);
                        entries.add(ModItems.COOKED_NOSE);

                        entries.add(ModItems.JOHN_SWORD);
                        entries.add(ModItems.JOHN_AXE);
                        entries.add(ModItems.JOHN_PICKAXE);
                        entries.add(ModItems.JOHN_SHOVEL);
                        entries.add(ModItems.JOHN_HOE);

                        entries.add(ModItems.NOSE_SPAWN_EGG);
                        entries.add(ModItems.WITCH_NOSE_SPAWN_EGG);

                        entries.add(ModBlocks.JOHN_BLOCK);
                        entries.add(ModBlocks.JOHN_FRAME);

                        entries.add(ModBlocks.JOHNSTONE);
                        entries.add(ModBlocks.JOHNSTONE_STAIRS);
                        entries.add(ModBlocks.JOHNSTONE_SLAB);
                        entries.add(ModBlocks.JOHNSTONE_WALL);



                    }).build());

    public static void registerItemGroups() {
        JohnMod.LOGGER.info("Registering Item Groups for " + JohnMod.MOD_ID);
    }


}
