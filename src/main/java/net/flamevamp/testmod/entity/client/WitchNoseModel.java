package net.flamevamp.testmod.entity.client;

import net.flamevamp.testmod.entity.custom.NoseEntity;
import net.flamevamp.testmod.entity.custom.WitchNoseEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class WitchNoseModel<T extends WitchNoseEntity> extends EntityModel<T> {
    private final ModelPart bb_main;

    public WitchNoseModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(4, 2).cuboid(0.0F, -4.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(0.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -4.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -4.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(0.0F, -4.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(0.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(0.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(0.0F, -4.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.35F, -5.0F, -1.55F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.35F, -5.0F, -1.55F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 12, 6);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}