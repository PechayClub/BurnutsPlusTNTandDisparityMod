// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCarminiteCannon<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "carminitecannon"), "main");
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart bone2;

	public ModelCarminiteCannon(ModelPart root) {
		this.bone4 = root.getChild("bone4");
		this.bone3 = root.getChild("bone3");
		this.bone2 = root.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 24)
				.addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(30, 0)
						.addBox(-4.0F, -8.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-1.0F, -7.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(4.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-10.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone4.render(poseStack, buffer, packedLight, packedOverlay);
		bone3.render(poseStack, buffer, packedLight, packedOverlay);
		bone2.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.xRot = headPitch / (180F / (float) Math.PI);
	}
}