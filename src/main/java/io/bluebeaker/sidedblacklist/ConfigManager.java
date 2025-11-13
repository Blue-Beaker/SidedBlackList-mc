package io.bluebeaker.sidedblacklist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import net.minecraftforge.fml.common.Loader;

import java.io.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigManager {
    public static final Logger LOGGER = Logger.getLogger("SidedBlacklist");

    public static final String CONFIG_NAME = "sidedblacklist.json";
    public static SidedBlacklistConfig config = new SidedBlacklistConfig();
    public static SidedBlacklistConfig old_config;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void read(){
        try {
            old_config=config;
            config=gson.fromJson(new JsonReader(new FileReader(new File(Loader.instance().getConfigDir(),CONFIG_NAME))),SidedBlacklistConfig.class);
            replaceNullValues(config,old_config);
        } catch (FileNotFoundException e) {
            config=new SidedBlacklistConfig();
        }
    }

    private static void replaceNullValues(SidedBlacklistConfig config, SidedBlacklistConfig defaults){
        for (Field declaredField : config.getClass().getDeclaredFields()) {
            try {
                if(declaredField.get(config)==null){
                    declaredField.set(config,declaredField.get(defaults));
                    LOGGER.log(Level.WARNING,"Config value '{}' is null",declaredField.getName());
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,"Exception reading config ",e);
            }
        }
    }
    public static void write(){
        String json = gson.toJson(config);
        try {
            FileWriter fw = new FileWriter(new File(Loader.instance().getConfigDir(),CONFIG_NAME));
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"Exception writing config: ",e);
        }
    }
    public static void refresh(){
        read();
        write();
    }

    static {
        refresh();
    }
}
