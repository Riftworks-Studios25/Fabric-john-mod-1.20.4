package net.flamevamp.testmod.entity.client;

import net.flamevamp.testmod.entity.custom.NoseEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NoseModel<T extends NoseEntity> extends EntityModel<T> {
	private final ModelPart bone;
	public NoseModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(2, 8).cuboid(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -4.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -4.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -2.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -4.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-4.0F, -2.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.0F, -4.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 24.0F, -4.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}