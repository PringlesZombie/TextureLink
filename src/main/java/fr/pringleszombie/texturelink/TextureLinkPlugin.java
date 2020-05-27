package fr.pringleszombie.texturelink;

import fr.pringleszombie.texturelink.commands.TextureCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextureLinkPlugin extends JavaPlugin
{
    private FileConfiguration config ;
    private String message;
    private HashMap<String,TextureConfig> texturesConfig = new HashMap<>();


    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.load();
        this.getCommand("texture").setExecutor(new TextureCommand(this));
    }

    @Override
    public void onDisable() {
    }



    private void load(){
        this.message = getConfig().getString("message");
        ConfigurationSection section = getConfig().getConfigurationSection("links");
        for(String key : section.getKeys(false)){
            ConfigurationSection sub = section.getConfigurationSection(key);
            System.out.println(key);
            texturesConfig.put(key,new TextureConfig(sub.getString("prefix"),sub.getString("link"),sub.getString("suffix")));
        }
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, TextureConfig> getTexturesConfig() {
        return texturesConfig;
    }
}
