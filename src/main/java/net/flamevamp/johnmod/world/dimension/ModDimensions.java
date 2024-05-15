package net.flamevamp.johnmod.world.dimension;

import net.flamevamp.johnmod.JohnMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.awt.*;
import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> DIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(JohnMod.MOD_ID, "dim"));
    public static final RegistryKey<World> LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(JohnMod.MOD_ID, "dim"));
    public static final RegistryKey<DimensionType> DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(JohnMod.MOD_ID, "dim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(DIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                false,
                false,
                false,
                true,
                1.0,
                true,
                false,
                0,
                256,
                256,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.THE_END_ID,
                1.0f,
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
