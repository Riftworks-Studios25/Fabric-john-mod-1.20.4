package net.flamevamp.testmod.world.biome;

import net.flamevamp.testmod.TestMod;
import net.flamevamp.testmod.entity.ModEntities;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> JOHN_PLAINS = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TestMod.MOD_ID, "john_plains"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(JOHN_PLAINS, johnPlains(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome johnPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.NOSE, 8, 1, 10));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 3, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WITCH, 1, 1, 4));


        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        return new Biome.Builder()
                .precipitation(false)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .temperature(0.8f)
                .downfall(0.4f)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x62)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
}
