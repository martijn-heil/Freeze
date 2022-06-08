package com.gitlab.martijn_heil.freeze;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FreezeCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("freeze.freeze")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Please specify a player.");
            return true;
        }

        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Too many arguments.");
            return true;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

        if (target.isOp()) {
            sender.sendMessage(ChatColor.RED + "This player is exempted from being frozen!");
            return true;
        }

        Freeze.setFrozen(target, true);
        sender.sendMessage(ChatColor.GREEN + "Froze " + target.getName());

        return true;
    }
}
