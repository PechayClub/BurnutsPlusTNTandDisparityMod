
package ch.teamburnuts.tnt_and_disparity.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Random;

import ch.teamburnuts.tnt_and_disparity.procedures.CarminiteCannonExplodeProcedure;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModItems;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModEntities;

public class CarminiteCannonFlyingEntity extends Monster implements RangedAttackMob {
	public CarminiteCannonFlyingEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(TntAndDisparityModEntities.CARMINITE_CANNON_FLYING, world);
	}

	public CarminiteCannonFlyingEntity(EntityType<CarminiteCannonFlyingEntity> type, Level world) {
		super(type, world);
		xpReward = 50;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TntAndDisparityModItems.CARMINITE_LAUNCHER_CANNON));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(TntAndDisparityModItems.CARMINITE_LAUNCHER_CANNON));
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1, 20) {
			@Override
			protected Vec3 getPosition() {
				Random random = CarminiteCannonFlyingEntity.this.getRandom();
				double dir_x = CarminiteCannonFlyingEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = CarminiteCannonFlyingEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = CarminiteCannonFlyingEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, (float) 128));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Villager.class, (float) 128));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, IronGolem.class, (float) 128));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, SnowGolem.class, (float) 128));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, StickmanEntity.class, (float) 128));
		this.goalSelector.addGoal(8, new FollowMobGoal(this, (float) 2, 16, 128));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Player.class, (float) 6, 1, 2));
		this.goalSelector.addGoal(10, new AvoidEntityGoal<>(this, Villager.class, (float) 6, 1, 2));
		this.goalSelector.addGoal(11, new AvoidEntityGoal<>(this, IronGolem.class, (float) 6, 1, 2));
		this.goalSelector.addGoal(12, new AvoidEntityGoal<>(this, SnowGolem.class, (float) 6, 1, 2));
		this.goalSelector.addGoal(13, new AvoidEntityGoal<>(this, StickmanEntity.class, (float) 6, 1, 2));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, SnowGolem.class, false, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, StickmanEntity.class, false, false));
		this.targetSelector.addGoal(19, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0D, 10, 20, 128.0F) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.armor_stand.hit"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.armor_stand.break"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion)
			return false;
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity sourceentity = source.getEntity();
		Entity entity = this;
		Level world = this.level;

		CarminiteCannonExplodeProcedure.execute(world, x, y, z, entity);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		CarminiteLauncherCannonEntity.shoot(this, target);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;
		for (int l = 0; l < 4; ++l) {
			double x0 = x + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
			double y0 = y + 1.2 + (random.nextFloat() - 0.5) * 0.5D * 100;
			double z0 = z + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
			world.addParticle(ParticleTypes.CLOUD, x0, y0, z0, 0, 0, 0);
		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 1);
		builder = builder.add(Attributes.MAX_HEALTH, 300);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5);
		builder = builder.add(Attributes.FLYING_SPEED, 1);
		return builder;
	}
}
