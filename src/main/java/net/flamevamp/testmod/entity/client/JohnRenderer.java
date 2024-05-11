package net.flamevamp.testmod.entity.client;

import net.flamevamp.testmod.TestMod;
import net.flamevamp.testmod.entity.custom.JohnEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JohnRenderer  extends MobEntityRenderer<JohnEntity, JohnModel<JohnEntity>> {
    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/entity/john.png");

    public JohnRenderer(EntityRendererFactory.Context context) {
        super(context, new JohnModel<>(context.getPart(ModModelLayers.JOHN)), 0.25f);
    }

    @Override
    public Identifier getTexture(JohnEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(JohnEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
