package io.bluebeaker.sidedblacklist;

import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class SidedBlacklistMod
{
    public static final String MODID = Tags.MOD_ID;
    public static final String NAME = Tags.MOD_NAME;
    public static final String VERSION = Tags.VERSION;

    public static Logger logger = LogManager.getLogger(MODID);

    public SidedBlacklistMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static Logger getLogger(){
        return logger;
    }
}
