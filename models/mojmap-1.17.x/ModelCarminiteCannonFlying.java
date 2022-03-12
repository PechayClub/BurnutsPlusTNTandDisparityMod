// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCarminiteCannonFlying<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "carminitecannonflying"), "main");
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart bone;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;

	public ModelCarminiteCannonFlying(ModelPart root) {
		this.bone4 = root.getChild("bone4");
		this.bone3 = root.getChild("bone3");
		this.bone2 = root.getChild("bone2");
		this.bone = root.getChild("bone");
		this.bone5 = root.getChild("bone5");
		this.bone6 = root.getChild("bone6");
		this.bone7 = root.getChild("bone7");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 3)
						.addBox(-8.0F, -18.0F, -8.0F, 16.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(11.0F, -17.0F, -15.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(11.0F, -17.0F, 11.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(-15.0F, -17.0F, 11.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(-15.0F, -17.0F, -15.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bone4.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, 3.0F, -1.0F, 40.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -19.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = bone4.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, 3.0F, -1.0F, 40.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -19.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(30, 27)
						.addBox(-4.0F, 4.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 14)
						.addBox(-1.0F, 5.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 24)
						.addBox(4.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-10.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(8, 10)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 24)
						.addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(13.0F, 7.0F, -13.0F));

		PartDefinition cube_r3 = bone
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(30, 24).addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(8, 10)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 24)
						.addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(13.0F, 7.0F, 13.0F));

		PartDefinition cube_r4 = bone5
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(30, 24).addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(8, 10)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 24)
						.addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-13.0F, 7.0F, 13.0F));

		PartDefinition cube_r5 = bone6
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(30, 24).addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(8, 10)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 24)
						.addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-13.0F, 7.0F, -13.0F));

		PartDefinition cube_r6 = bone7
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(30, 24).addBox(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone4.render(poseStack, buffer, packedLight, packedOverlay);
		bone3.render(poseStack, buffer, packedLight, packedOverlay);
		bone2.render(poseStack, buffer, packedLight, packedOverlay);
		bone.render(poseStack, buffer, packedLight, packedOverlay);
		bone5.render(poseStack, buffer, packedLight, packedOverlay);
		bone6.render(poseStack, buffer, packedLight, packedOverlay);
		bone7.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.xRot = headPitch / (180F / (float) Math.PI);
		this.bone5.yRot = ageInTicks;
		this.bone.yRot = ageInTicks;
		this.bone7.yRot = ageInTicks;
		this.bone6.yRot = ageInTicks;
	}
}