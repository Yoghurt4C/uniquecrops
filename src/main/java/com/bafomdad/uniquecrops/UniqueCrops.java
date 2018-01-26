package com.bafomdad.uniquecrops;

import com.bafomdad.uniquecrops.core.UCTab;
import com.bafomdad.uniquecrops.gui.GuiHandler;
import com.bafomdad.uniquecrops.integration.crafttweaker.CraftTweakerPlugin;
import com.bafomdad.uniquecrops.proxies.CommonProxy;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = UniqueCrops.MOD_ID, name = UniqueCrops.MOD_NAME, version = UniqueCrops.VERSION, dependencies = "after:forge@[" + UniqueCrops.FORGE_VER + ",);before:jei;")
public class UniqueCrops {

  public static final String MOD_ID = "uniquecrops";
  public static final String MOD_NAME = "Unique Crops";
  public static final String VERSION = "@VERSION@";
  public static final String FORGE_VER = "14.23.1.2556";

  @SidedProxy(clientSide = "com.bafomdad.uniquecrops.proxies.ClientProxy", serverSide = "com.bafomdad.uniquecrops.proxies.CommonProxy")
  public static CommonProxy proxy;

  @Mod.Instance(MOD_ID)
  public static UniqueCrops instance;

  public static UCTab TAB = new UCTab();

  public static boolean baublesLoaded = Loader.isModLoaded("baubles");
  public static boolean ieLoaded = Loader.isModLoaded("immersiveengineering");

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {

    NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

    proxy.preInit(event);
    proxy.checkResource();
    proxy.initAllModels();
  }

  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {

    proxy.registerColors();
    proxy.init(event);
    proxy.initEntityRender();
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    proxy.postInit(event);
  }

  @Mod.EventHandler
  public void onLoadComplete(FMLLoadCompleteEvent event) {

    if (Loader.isModLoaded("crafttweaker")) {
      CraftTweakerPlugin.apply();
    }
  }

}