package net.flamevamp.johnmod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent RAW_NOSE = new FoodComponent.Builder().hunger(1)
            .saturationModifier(0.2f).meat().build();

    public static final FoodComponent COOKED_NOSE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(0.8f).meat().build();

    public static final FoodComponent JOHN_NOSE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(1.2f).meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0), 1.0f).build();
}

