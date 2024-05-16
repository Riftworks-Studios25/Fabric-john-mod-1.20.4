package net.flamevamp.johnmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.entity.custom.JohnEntity;
import net.flamevamp.johnmod.entity.custom.NoseEntity;
import net.flamevamp.johnmod.entity.custom.WitchNoseEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<NoseEntity> NOSE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JohnMod.MOD_ID, "nose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NoseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.33f)).build());

    public static final EntityType<WitchNoseEntity> WITCH_NOSE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JohnMod.MOD_ID, "witch_nose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WitchNoseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.33f)).build());

    public static final EntityType<JohnEntity> JOHN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JohnMod.MOD_ID, "john"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, JohnEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());

    public static void registerModEntities() {
        JohnMod.LOGGER.info("Registering Entities for " + JohnMod.MOD_ID);
    }
}
