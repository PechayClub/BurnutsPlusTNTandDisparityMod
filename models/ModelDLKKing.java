// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelDLKKing extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leftArm;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer leftleg2;
	private final ModelRenderer rightLeg;
	private final ModelRenderer rightleg2;

	public ModelDLKKing() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, -14.0F, -2.0F, 8.0F, 12.0F, 4.0F, 2.0F, true);
		body.setTextureOffset(24, 0).addBox(-3.0F, -25.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(24, 0).addBox(-1.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-3.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(2.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(2.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-3.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-3.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(0.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(2.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(24, 0).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.setTextureOffset(24, 0).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(24, 0).addBox(-3.0F, -1.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-6.0F, -12.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -16.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(6.0F, -12.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		setRotationAngle(leftLeg, 0.0F, -1.5708F, 0.0F);
		leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(0.1F, 6.0F, 0.0F);
		leftLeg.addChild(leftleg2);
		leftleg2.setTextureOffset(32, 6).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		setRotationAngle(rightLeg, 0.0F, -1.5708F, 0.0F);
		rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, true);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-0.1F, 6.0F, 0.0F);
		rightLeg.addChild(rightleg2);
		setRotationAngle(rightleg2, -1.5708F, 0.0F, 0.0F);
		rightleg2.setTextureOffset(32, 6).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
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
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}