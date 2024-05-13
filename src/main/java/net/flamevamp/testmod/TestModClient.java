package net.flamevamp.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.flamevamp.testmod.entity.ModEntities;
import net.flamevamp.testmod.entity.client.*;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NOSE, NoseModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.NOSE, NoseRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WITCH_NOSE, WitchNoseModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.WITCH_NOSE, WitchNoseRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JOHN, JohnModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.JOHN, JohnRenderer::new);


    }
}
