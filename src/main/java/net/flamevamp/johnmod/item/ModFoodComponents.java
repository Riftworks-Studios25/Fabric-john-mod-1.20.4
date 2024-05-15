package net.flamevamp.johnmod.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent RAW_NOSE = new FoodComponent.Builder().hunger(1)
            .saturationModifier(0.25f).meat().build();

    public static final FoodComponent COOKED_NOSE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(0.50f).meat().build();
}

