package com.henrikstabell.nmclc;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
@IFMLLoadingPlugin.MCVersion(value = "1.7.10")
@IFMLLoadingPlugin.Name("NMCLC")
@IFMLLoadingPlugin.TransformerExclusions({"com.henrikstabell.nmclc.NMCLCCoreMod", "com.henrikstabell.nmclc.NMCLCMod"})
@IFMLLoadingPlugin.SortingIndex(1001)
public class NMCLCCoreMod implements IFMLLoadingPlugin {

    public static boolean obfuscatedEnvironment = false;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"com.henrikstabell.nmclc.TransformerGuiChat"};
    }

    @Override
    public String getModContainerClass() {
        return "com.henrikstabell.nmclc.NMCLCMod";
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