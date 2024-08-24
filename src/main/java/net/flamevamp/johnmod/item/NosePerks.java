package net.flamevamp.johnmod.item;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.toast.Toast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NosePerks extends Item {
    public NosePerks(Settings settings) {
        super(settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                ItemStack headPiece = player.getEquippedStack(EquipmentSlot.HEAD);
                if (headPiece.isOf(ModItems.JOHN_NOSE)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,
                            1, 1, false, false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,
                            1, 0, false, false));
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
