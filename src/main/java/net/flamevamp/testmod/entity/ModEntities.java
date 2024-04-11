package net.flamevamp.testmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.flamevamp.testmod.TestMod;
import net.flamevamp.testmod.entity.custom.NoseEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<NoseEntity> NOSE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "nose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NoseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.33f)).build());

    public static void registerModEntities() {
        TestMod.LOGGER.info("Registering Entities for " + TestMod.MOD_ID);
    }
}
