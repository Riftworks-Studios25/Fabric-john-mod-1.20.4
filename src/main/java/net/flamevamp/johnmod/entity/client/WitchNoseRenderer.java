package net.flamevamp.johnmod.entity.client;

import net.flamevamp.johnmod.JohnMod;
import net.flamevamp.johnmod.entity.custom.NoseEntity;
import net.flamevamp.johnmod.entity.custom.WitchNoseEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WitchNoseRenderer extends MobEntityRenderer<WitchNoseEntity, WitchNoseModel<WitchNoseEntity>> {
    private static final Identifier TEXTURE = new Identifier(JohnMod.MOD_ID, "textures/entity/witch_nose.png");

    public WitchNoseRenderer(EntityRendererFactory.Context context) {
        super(context, new WitchNoseModel<>(context.getPart(ModModelLayers.WITCH_NOSE)), 0.2f);
    }

    @Override
    public Identifier getTexture(WitchNoseEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(WitchNoseEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
