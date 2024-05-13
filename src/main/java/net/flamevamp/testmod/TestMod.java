package net.flamevamp.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.flamevamp.testmod.block.ModBlocks;
import net.flamevamp.testmod.entity.ModEntities;
import net.flamevamp.testmod.entity.custom.JohnEntity;
import net.flamevamp.testmod.entity.custom.NoseEntity;
import net.flamevamp.testmod.item.ModItemGroups;
import net.flamevamp.testmod.item.ModItems;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.EndGatewayFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.NOSE, NoseEntity.createNoseAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WITCH_NOSE, NoseEntity.createNoseAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.JOHN, JohnEntity.createJohnAttributes());

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.JOHN_BLOCK)
				.lightWithItem(ModItems.JOHN_SHARD)
				.destDimID(new Identifier(TestMod.MOD_ID, "dim"))
				.tintColor(156, 109, 37)
				.registerPortal();
	}

}