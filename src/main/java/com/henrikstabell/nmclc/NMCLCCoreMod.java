package com.henrikstabell.nmclc;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
@IFMLLoadingPlugin.MCVersion(value = "1.10.2")
@IFMLLoadingPlugin.Name("NMCLC")
@IFMLLoadingPlugin.TransformerExclusions({ "com.henrikstabell.nmclc.NMCLCCoreMod", "com.henrikstabell.nmclc.NMCLCMod" })
@IFMLLoadingPlugin.DependsOn("forge")
@IFMLLoadingPlugin.SortingIndex(1002)
public class NMCLCCoreMod implements IFMLLoadingPlugin {

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
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}