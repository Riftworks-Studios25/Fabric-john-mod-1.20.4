package net.flamevamp.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.flamevamp.testmod.entity.ModEntities;
import net.flamevamp.testmod.entity.client.ModModelLayers;
import net.flamevamp.testmod.entity.client.NoseModel;
import net.flamevamp.testmod.entity.client.NoseRenderer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NOSE, NoseModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.NOSE, NoseRenderer::new);


    }
}
