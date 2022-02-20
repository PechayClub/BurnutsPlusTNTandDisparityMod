package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class RemoteBBBParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.CRIT, x, y, z, 0, 0, 0);
	}
}
