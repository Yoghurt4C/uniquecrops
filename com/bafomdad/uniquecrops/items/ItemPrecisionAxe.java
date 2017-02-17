package com.bafomdad.uniquecrops.items;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.bafomdad.uniquecrops.UniqueCrops;
import com.bafomdad.uniquecrops.core.IBookUpgradeable;
import com.bafomdad.uniquecrops.init.UCItems;

public class ItemPrecisionAxe extends ItemAxe implements IBookUpgradeable {
	
	public ItemPrecisionAxe() {
		
		super(ToolMaterial.DIAMOND);
		setRegistryName("precision.axe");
		setUnlocalizedName(UniqueCrops.MOD_ID + ".precision.axe");
		setCreativeTab(UniqueCrops.TAB);
		GameRegistry.register(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean whatisthis) {
		
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(ItemGeneric.TAG_UPGRADE)) {
			int upgradelevel = stack.getTagCompound().getInteger(ItemGeneric.TAG_UPGRADE);
			list.add(TextFormatting.GOLD + "+" + upgradelevel);
		}
		else
			list.add(TextFormatting.GOLD + "Upgradeable");
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
    	
		boolean sametool = toRepair.getItem() == repair.getItem();
		boolean flag = repair.getItem() == UCItems.generic && repair.getItemDamage() == 8;
		return sametool || flag;
    }
	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		
		stack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
		super.onCreated(stack, world, player);
	}
}
