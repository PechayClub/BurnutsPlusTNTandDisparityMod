// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelDLKKing extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer crown;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer leftLeg2;
	private final ModelRenderer rightLeg;
	private final ModelRenderer rightLeg2;

	public ModelDLKKing() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-7.0F, -16.0F, -5.0F, 14.0F, 16.0F, 10.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -16.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 26).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(16, 52).addBox(-0.5F, -3.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 52).addBox(-0.5F, -2.5F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		crown = new ModelRenderer(this);
		crown.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(crown);
		crown.setTextureOffset(0, 58).addBox(-3.0F, -9.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(0.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(2.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(2.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(2.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(2.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(0.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-1.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-3.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-3.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		crown.setTextureOffset(12, 58).addBox(-3.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -8.0F, 0.0F);
		crown.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 58).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -8.0F, 0.0F);
		crown.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.setTextureOffset(0, 58).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -8.0F, 0.0F);
		crown.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(0, 58).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-7.0F, -12.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(0, 42).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(7.0F, -12.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(32, 26).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

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
		setRotationAngle(rightLeg2, 0.0F, 0.0F, -1.5708F);
		rightLeg2.setTextureOffset(38, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}