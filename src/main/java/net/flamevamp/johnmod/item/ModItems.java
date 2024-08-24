package net.flamevamp.johnmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.entity.ModEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.WearableCarvedPumpkinBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModItems {
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
    private static List<Identifier> getJohnUpgradeEmptyBaseSlotTextures() {
        return List.of( EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static final Identifier EMPTY_SLOT_JOHN_NOSE_TEXTURE = new Identifier("johnmod:item/empty_slot_john_nose");
    private static List<Identifier> getJohnUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_JOHN_NOSE_TEXTURE);
    }

    public static final Item JOHN_SHARD = registerItem("john_shard",
            new Item(new FabricItemSettings()));
    public static final Item JOHN_NOSE = registerItem("john_nose",
            new NosePerks(new FabricItemSettings().equipmentSlot(new HeadSlotThing()).food(ModFoodComponents.JOHN_NOSE)));
    public static final Item JOHN_NOSE_FRAGMENT = registerItem("john_nose_fragment",
            new Item(new FabricItemSettings()));
    public static final Item SHARD_AND_POWDER = registerItem("shard_and_powder",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item JOHN_PICKAXE = registerItem("john_pickaxe",
            new PickaxeItem(ModToolMaterial.JOHN, 1, -2.8f,
                    new FabricItemSettings().fireproof()));
    public static final Item JOHN_AXE = registerItem("john_axe",
            new AxeItem(ModToolMaterial.JOHN, 5, -3.0f,
                    new FabricItemSettings().fireproof()));
    public static final Item JOHN_SHOVEL = registerItem("john_shovel",
            new ShovelItem(ModToolMaterial.JOHN, 1.5f, -3.0f,
                    new FabricItemSettings().fireproof()));
    public static final Item JOHN_HOE = registerItem("john_hoe",
            new HoeItem(ModToolMaterial.JOHN, -4, 0.0f,
                    new FabricItemSettings().fireproof()));
    public static final Item JOHN_SWORD = registerItem("john_sword",
            new SwordItem(ModToolMaterial.JOHN, 3, -2.4f,
                    new FabricItemSettings().fireproof()));

    public static final Item RAW_NOSE = registerItem("raw_nose",
            new Item(new FabricItemSettings().equipmentSlot(new HeadSlotThing()).food(ModFoodComponents.RAW_NOSE)));
    public static final Item COOKED_NOSE = registerItem("cooked_nose",
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_NOSE)));

    public static final Item JOHN_UPGRADE_SMITHING_TEMPLATE = registerItem("john_upgrade_smithing_template",
            new SmithingTemplateItem(Text.literal("Netherite Tools").formatted(Formatting.BLUE), Text.literal("John's Nose").formatted(Formatting.BLUE), Text.literal("John Upgrade").formatted(Formatting.GRAY), Text.literal("Add netherite tool or weapon"), Text.literal("Add John's Nose"), getJohnUpgradeEmptyBaseSlotTextures(), getJohnUpgradeEmptyAdditionsSlotTextures()));
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
