package com.henrikstabell.nmclc;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * Created by Hennamann(Ole Henrik Stabell) on 08/03/2018.
 */
@IFMLLoadingPlugin.MCVersion(value = "1.11.2")
@IFMLLoadingPlugin.Name("NMCLC")
@IFMLLoadingPlugin.TransformerExclusions({"com.henrikstabell.nmclc.NMCLCCoreMod", "com.henrikstabell.nmclc.NMCLC"})
@IFMLLoadingPlugin.SortingIndex(1001)
public class NMCLCCoreMod implements IFMLLoadingPlugin {

    public static boolean obfuscatedEnvironment = false;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"com.henrikstabell.nmclc.TransformerMinecraftServerGui"};
    }

    @Override
    public String getModContainerClass() {
        return null;
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