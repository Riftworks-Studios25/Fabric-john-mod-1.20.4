package net.flamevamp.johnmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.flamevamp.johnmod.datagen.*;
import net.flamevamp.johnmod.item.ModFoodComponents;
import net.flamevamp.johnmod.item.ModItems;
import net.flamevamp.johnmod.world.biome.ModBiomes;
import net.flamevamp.johnmod.world.dimension.ModDimensions;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class JohnModDataGenerator implements DataGeneratorEntrypoint {
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
	}

	static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput dataGenerator) {
			super(dataGenerator);

		}

		@Override
		public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
			AdvancementEntry rootAdvancement = Advancement.Builder.create()
					.display(
							ModItems.JOHN_SHARD, // The display icon
							Text.literal("John?"), // The title
							Text.literal("Start your journey by obtaining a John Shard"), // The description
							new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("got_john_shard", InventoryChangedCriterion.Conditions.items(ModItems.JOHN_SHARD))
					.build(consumer, "johnmod" + "/root");

			AdvancementEntry cookedNose = Advancement.Builder.create().parent(rootAdvancement)
					.display(
							ModItems.COOKED_NOSE, // The display icon
							Text.literal("Something Smells Good"), // The title
							Text.literal("Obtain a Cooked Nose"), // The description
							null,
							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("got_cooked_nose", InventoryChangedCriterion.Conditions.items(ModItems.COOKED_NOSE))
					.build(consumer, "johnmod" + "/got_cooked_nose");

			AdvancementEntry noseFragment = Advancement.Builder.create().parent(rootAdvancement)
					.display(
							ModItems.JOHN_NOSE_FRAGMENT, // The display icon
							Text.literal("The Scent of Victory"), // The title
							Text.literal("Kill John and obtain a Fragment of his Nose"), // The description
							null,							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("got_john_fragment", InventoryChangedCriterion.Conditions.items(ModItems.JOHN_NOSE_FRAGMENT))
					.build(consumer, "johnmod" + "/got_john_fragment");

			AdvancementEntry eatJohnNose = Advancement.Builder.create().parent(cookedNose)
					.display(
							ModItems.JOHN_NOSE, // The display icon
							Text.literal("Something Tastes Good"), // The title
							Text.literal("Eat John's Nose"), // The description
							null,							AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("eat_john_nose", ConsumeItemCriterion.Conditions.item(ModItems.JOHN_NOSE))
					.build(consumer, "johnmod" + "/eat_john_nose");
		}
	}
}
