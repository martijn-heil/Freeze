package com.gitlab.martijn_heil.freeze;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnfreezeCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender.hasPermission("freeze.freeze"))
        {
            if(args.length < 1)
            {
                sender.sendMessage(ChatColor.RED + "Please specify a player.");
                return true;
            }

            if(args.length > 1)
            {
                sender.sendMessage(ChatColor.RED + "Too many arguments.");
                return true;
            }

            OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);

            if(p.equals(sender))
            {
                sender.sendMessage(ChatColor.RED + "You can not freeze yourself.");
                return true;
            }

            Freeze.setFrozen(p, false);
            sender.sendMessage(ChatColor.GREEN + "Unfroze " + p.getName());
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
        }

        return true;
    }
}
