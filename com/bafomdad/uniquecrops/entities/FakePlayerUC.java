package com.bafomdad.uniquecrops.entities;

import com.bafomdad.uniquecrops.network.FakeNetHandlerPlayServer;
import com.mojang.authlib.GameProfile;

import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class FakePlayerUC extends FakePlayer {

	public FakePlayerUC(World world, BlockPos pos, GameProfile profile) {
		
		super(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(world.provider.getDimension()), profile);
		posX = pos.getX() + 0.5;
		posY = pos.getY() + 0.5;
		posZ = pos.getZ() + 0.5;
		this.connection = new FakeNetHandlerPlayServer(this);
	}
	
    @Override
    protected void onNewPotionEffect(PotionEffect p_70670_1_)
    {
    }

    @Override
    protected void onChangedPotionEffect(PotionEffect effect, boolean p_70695_2_)
    {
    }

    @Override
    protected void onFinishedPotionEffect(PotionEffect effect)
    {
    }
}
