package com.bafomdad.uniquecrops.crops;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.bafomdad.uniquecrops.UniqueCrops;
import com.bafomdad.uniquecrops.blocks.BlockCropsBase;
import com.bafomdad.uniquecrops.core.EnumCrops;
import com.bafomdad.uniquecrops.init.UCItems;

public class Invisibilia extends BlockCropsBase {

	public Invisibilia() {
		
		super(EnumCrops.INVISIBLEPLANT, true);
	}
	
	@Override
	public Item getSeed() {
		
		return UCItems.seedsInvisibilia;
	}
	
	@Override
	public Item getCrop() {
		
		return UCItems.generic;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		
		if (getAge(state) < getMaxAge())
			return 0;
		
		return 11;
	}
	
	@Override
    public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
		
		if (!UniqueCrops.proxy.invisiTrace()) {
			return null;
		}
		return super.collisionRayTrace(state, world, pos, start, end);
	}
}
