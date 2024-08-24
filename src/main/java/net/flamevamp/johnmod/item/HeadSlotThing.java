package net.flamevamp.johnmod.item;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HeadSlotThing implements EquipmentSlotProvider {@Override public EquipmentSlot getPreferredEquipmentSlot(ItemStack stack) {return EquipmentSlot.HEAD;}}
