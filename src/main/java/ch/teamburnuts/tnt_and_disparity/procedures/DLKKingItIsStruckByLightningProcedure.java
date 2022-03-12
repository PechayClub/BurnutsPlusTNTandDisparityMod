package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class DLKKingItIsStruckByLightningProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("NOOOOOOOOOOOOOOO!!!"), (false));
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 80, Explosion.BlockInteraction.DESTROY);
		if (!entity.level.isClientSide())
			entity.discard();
	}
}
