package io.bluebeaker.sidedblacklist;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.logging.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class SidedBlacklistMod
{
    public static final String MODID = Tags.MOD_ID;
    public static final String NAME = Tags.MOD_NAME;
    public static final String VERSION = Tags.VERSION;
    public static final Logger LOGGER = Logger.getLogger("SidedBlacklistMod");

    public MinecraftServer server;
    
    public SidedBlacklistMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void onServerStart(FMLServerStartingEvent event){
        this.server=event.getServer();
    }

    public static Logger getLogger(){
        return LOGGER;
    }
}
