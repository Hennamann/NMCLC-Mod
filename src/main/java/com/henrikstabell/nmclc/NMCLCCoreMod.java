package com.henrikstabell.nmclc;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
@IFMLLoadingPlugin.MCVersion(value = "1.10.2")
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