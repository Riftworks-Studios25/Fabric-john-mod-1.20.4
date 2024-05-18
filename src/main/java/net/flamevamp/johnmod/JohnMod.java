package net.flamevamp.johnmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.flamevamp.johnmod.block.ModBlocks;
import net.flamevamp.johnmod.entity.ModEntities;
import net.flamevamp.johnmod.entity.custom.JohnEntity;
import net.flamevamp.johnmod.entity.custom.NoseEntity;
import net.flamevamp.johnmod.item.ModItemGroups;
import net.flamevamp.johnmod.item.ModItems;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.EndGatewayFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JohnMod implements ModInitializer {
	public static final String MOD_ID = "johnmod";
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
				.frameBlock(ModBlocks.JOHN_FRAME)
				.lightWithItem(ModItems.SHARD_AND_POWDER)
				.destDimID(new Identifier(JohnMod.MOD_ID, "dim"))
				.tintColor(53318)
				.registerPortal();
	}

}