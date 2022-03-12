
package ch.teamburnuts.tnt_and_disparity.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
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

import ch.teamburnuts.tnt_and_disparity.procedures.CarminiteCannonExplodeProcedure;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModItems;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModEntities;

public class CarminiteCannonEntity extends Monster implements RangedAttackMob {
	public CarminiteCannonEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(TntAndDisparityModEntities.CARMINITE_CANNON, world);
	}

	public CarminiteCannonEntity(EntityType<CarminiteCannonEntity> type, Level world) {
		super(type, world);
		xpReward = 50;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TntAndDisparityModItems.CARMINITE_LAUNCHER_CANNON));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(TntAndDisparityModItems.CARMINITE_LAUNCHER_CANNON));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, CarminiteCannonEntity.class, (float) 128));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Villager.class, (float) 128));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, IronGolem.class, (float) 128));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, SnowGolem.class, (float) 128));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, StickmanEntity.class, (float) 128));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, SnowGolem.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, StickmanEntity.class, false, false));
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

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 300);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
		return builder;
	}
}
