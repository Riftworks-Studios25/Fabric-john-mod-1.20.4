package net.flamevamp.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.flamevamp.testmod.TestMod;
import net.flamevamp.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JOHN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "john"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.john"))
                    .icon(() -> new ItemStack(ModItems.JOHN_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.JOHN_SHARD);
                        entries.add(ModBlocks.JOHN_BLOCK);



                    }).build());

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }


}
