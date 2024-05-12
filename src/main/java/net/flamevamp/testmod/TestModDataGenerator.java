package net.flamevamp.testmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.flamevamp.testmod.datagen.*;
import net.flamevamp.testmod.item.ModItems;
import net.flamevamp.testmod.world.biome.ModBiomes;
import net.flamevamp.testmod.world.dimension.ModDimensions;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(AdvancementsProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
	}

	static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput dataGenerator) {
			super(dataGenerator);

		}

		@Override
		public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
			AdvancementEntry rootAdvancement = Advancement.Builder.create()
					.display(
							ModItems.COOKED_NOSE, // The display icon
							Text.literal("Something Smells Good"), // The title
							Text.literal("Obtain a Cooked Nose"), // The description
							new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("got_cooked_nose", InventoryChangedCriterion.Conditions.items(ModItems.COOKED_NOSE))
					.build(consumer, "testmod" + "/root");
		}
	}
}
