package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModParticles;

public class EkorShooterWhileBulletFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(TntAndDisparityModParticles.EKOR_PARTICLES, x, y, z, 0, 1, 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:ekorekors")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:ekorekors")),
						SoundSource.HOSTILE, 1, 1, false);
			}
		}
	}
}
