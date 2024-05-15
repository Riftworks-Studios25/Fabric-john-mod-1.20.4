package net.flamevamp.johnmod.entity.client;

import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.entity.custom.NoseEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NoseRenderer extends MobEntityRenderer<NoseEntity, NoseModel<NoseEntity>> {
    private static final Identifier TEXTURE = new Identifier(JohnMod.MOD_ID, "textures/entity/nose.png");

    public NoseRenderer(EntityRendererFactory.Context context) {
        super(context, new NoseModel<>(context.getPart(ModModelLayers.NOSE)), 0.2f);
    }

    @Override
    public Identifier getTexture(NoseEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(NoseEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
