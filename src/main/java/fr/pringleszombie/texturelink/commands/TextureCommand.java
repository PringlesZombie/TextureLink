package fr.pringleszombie.texturelink.commands;

import fr.pringleszombie.texturelink.TextureConfig;
import fr.pringleszombie.texturelink.TextureLinkPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;


public class TextureCommand implements CommandExecutor {


    private static final String DEFAULT_KEY = "default";

    private TextureLinkPlugin plugin;


    public TextureCommand(TextureLinkPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        HashMap<String,TextureConfig> texturesConfig = plugin.getTexturesConfig();
        ComponentBuilder builder = new ComponentBuilder();
        builder.append(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',plugin.getMessage())));
        builder.append("\n");


        for(String key : texturesConfig.keySet()){
            TextureConfig tc = texturesConfig.get(key);
            BaseComponent[] prefix = TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',tc.getPrefix()));
            TextComponent link = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',tc.getLink())));
            link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,tc.getLink()));
            BaseComponent[] suffix =   TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',tc.getSuffix()));
            builder.append(prefix).append(link).append(suffix).append("\n");
        }

        commandSender.spigot().sendMessage(builder.create());

        return true;
    }
}
