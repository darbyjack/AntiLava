package me.glaremasters.antilava.commands;

import me.glaremasters.antilava.Antilava;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters
 * Date: 8/7/2018
 * Time: 12:41 PM
 */
public class CMDReload implements CommandExecutor {

    private Antilava antilava;

    public CMDReload(Antilava antilava) {
        this.antilava = antilava;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("antilava.reload")) return true;
        }
        antilava.reloadConfig();
        return true;
    }
}
