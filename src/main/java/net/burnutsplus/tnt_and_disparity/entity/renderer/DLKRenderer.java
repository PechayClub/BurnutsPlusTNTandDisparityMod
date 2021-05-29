package net.burnutsplus.tnt_and_disparity.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.burnutsplus.tnt_and_disparity.entity.DLKEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DLKRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DLKEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelDLKModel(), 0.9f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("tnt_and_disparity:textures/dlk.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelDLKModel extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer leftArm;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftLeg;
		private final ModelRenderer leftLeg2;
		private final ModelRenderer rightLeg;
		private final ModelRenderer rightLeg2;
		private final ModelRenderer rightLeg_r1;
		public ModelDLKModel() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -4.0F, 0.0F);
			head.setTextureOffset(0, 26).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(16, 52).addBox(-0.5F, -3.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(16, 52).addBox(-0.5F, -2.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 12.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-7.0F, -16.0F, -5.0F, 14.0F, 16.0F, 10.0F, 0.0F, false);
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(-7.0F, 0.0F, 0.0F);
			leftArm.setTextureOffset(0, 42).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(7.0F, 0.0F, 0.0F);
			rightArm.setTextureOffset(32, 26).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			leftLeg.setTextureOffset(48, 10).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			leftLeg2 = new ModelRenderer(this);
			leftLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
			leftLeg.addChild(leftLeg2);
			leftLeg2.setTextureOffset(16, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
			rightLeg.setTextureOffset(32, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			rightLeg2 = new ModelRenderer(this);
			rightLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
			rightLeg.addChild(rightLeg2);
			rightLeg_r1 = new ModelRenderer(this);
			rightLeg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightLeg2.addChild(rightLeg_r1);
			setRotationAngle(rightLeg_r1, 0.0F, 0.0F, -1.5708F);
			rightLeg_r1.setTextureOffset(38, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
