package fr.pringleszombie.texturelink.commands;

import fr.pringleszombie.texturelink.TextureLinkPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;




public class TextureLinkCommand implements CommandExecutor {

    private final TextureLinkPlugin plugin;

    public TextureLinkCommand(TextureLinkPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {


        if(!commandSender.hasPermission("texturelink.reload"))
            return false;


        if(args.length == 1 && (args[0].equals("reload") || args[0].equals("rl"))){
            plugin.reloadConfig();
            plugin.load();

            TextComponent success = new TextComponent("Reload completed");
            success.setColor(ChatColor.GREEN);
            commandSender.spigot().sendMessage(success);
            return true;
        }

        return false;
    }


}
