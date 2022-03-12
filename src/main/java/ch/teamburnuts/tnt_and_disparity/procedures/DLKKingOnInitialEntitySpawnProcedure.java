package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

public class DLKKingOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:dlkkingsaying")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:dlkkingsaying")),
						SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (!world.isClientSide()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.broadcastMessage(new TextComponent(("<" + new TranslatableComponent("entity.tnt_and_disparity.dlk_king").getString() + "> "
								+ "Do you wanna challenge me? Then lets fight.")), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
