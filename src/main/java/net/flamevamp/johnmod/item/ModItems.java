package net.flamevamp.johnmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item JOHN_SHARD = registerItem("john_shard",
            new Item(new FabricItemSettings()));
    public static final Item RAW_NOSE = registerItem("raw_nose",
            new Item(new FabricItemSettings().food(ModFoodComponents.RAW_NOSE)));
    public static final Item COOKED_NOSE = registerItem("cooked_nose",
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_NOSE)));

    public static final Item NOSE_SPAWN_EGG = registerItem("nose_spawn_egg",
            new SpawnEggItem(ModEntities.NOSE, 0xa905E43, 0xa905E43,
                    new FabricItemSettings()));
    public static final Item WITCH_NOSE_SPAWN_EGG = registerItem("witch_nose_spawn_egg",
            new SpawnEggItem(ModEntities.WITCH_NOSE, 0xa905E43, 808000,
                    new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(JOHN_SHARD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JohnMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        JohnMod.LOGGER.info("Registering Mod Items for " + JohnMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(
                //ModItems::addItemsToIngredientItemGroup);
    }


}
