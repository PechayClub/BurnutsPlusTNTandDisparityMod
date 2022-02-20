// Made with Blockbench 4.1.4
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelStickmanModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stickmanmodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public ModelStickmanModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftArm = root.getChild("leftArm");
		this.rightArm = root.getChild("rightArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 30).addBox(
				-1.0F, 4.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = partdefinition
				.addOrReplaceChild("leftArm",
						CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition rightArm = partdefinition
				.addOrReplaceChild("rightArm",
						CubeListBuilder.create().texOffs(16, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition leftLeg = partdefinition
				.addOrReplaceChild("leftLeg",
						CubeListBuilder.create().texOffs(8, 16).addBox(-1.1F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.1F, 15.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg",
				CubeListBuilder.create().texOffs(0, 16).addBox(-0.9F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1F, 15.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}