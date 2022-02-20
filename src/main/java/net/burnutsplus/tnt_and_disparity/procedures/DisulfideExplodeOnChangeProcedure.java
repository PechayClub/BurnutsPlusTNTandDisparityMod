package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class DisulfideExplodeOnChangeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		while (blockstate.getMaterial() == net.minecraft.world.level.material.Material.FIRE
				|| blockstate.getMaterial() == net.minecraft.world.level.material.Material.LAVA) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 6, Explosion.BlockInteraction.BREAK);
		}
		while (blockstate.getMaterial() == net.minecraft.world.level.material.Material.LAVA) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = Blocks.LAVA.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.save(new CompoundTag());
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
	}
}
