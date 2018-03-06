package com.henrikstabell.nmclc;

import net.minecraftforge.classloading.FMLForgePlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
@IFMLLoadingPlugin.MCVersion(value = "1.10.2")
@IFMLLoadingPlugin.Name("NMCLC")
@IFMLLoadingPlugin.TransformerExclusions({"com.henrikstabell.nmclc.NMCLCCoreMod", "com.henrikstabell.nmclc.NMCLCMod"})
@IFMLLoadingPlugin.SortingIndex(1001)
public class NMCLCCoreMod implements IFMLLoadingPlugin {

    public static boolean obfuscatedEnvironment = false;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"com.henrikstabell.nmclc.TransformerGuiScreen"};
    }

    @Override
    public String getModContainerClass() {
        return NMCLCMod.class.getName();
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        obfuscatedEnvironment = (Boolean)data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}