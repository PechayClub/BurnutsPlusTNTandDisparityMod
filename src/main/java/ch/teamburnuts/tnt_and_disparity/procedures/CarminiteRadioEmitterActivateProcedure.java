package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModParticles;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingEntity;

public class CarminiteRadioEmitterActivateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CarminiteCannonFlyingEntity) {
			world.addParticle(TntAndDisparityModParticles.EKOR_PARTICLES, x, y, z, 0, 1, 0);
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"tp @e[type=tnt_and_disparity:carminite_cannon_flying_for_player] @p");
			}
		}
	}
}
