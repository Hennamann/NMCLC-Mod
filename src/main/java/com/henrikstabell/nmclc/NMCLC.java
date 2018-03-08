package com.henrikstabell.nmclc;

import com.henrikstabell.nmclc.handler.ChatHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = NMCLC.MODID, version = NMCLC.VERSION, name = NMCLC.NAME)
public class NMCLC
{
    public static final String MODID = "nmclc";
    public static final String VERSION = "1.2.0";
    public static final String NAME = "NMCLC (NoMoreCapsLockCommands)";

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registerClientHandlers();
    }

    @SideOnly(Side.CLIENT)
    public static void registerClientHandlers() {
        MinecraftForge.EVENT_BUS.register(new ChatHandler());
    }
}