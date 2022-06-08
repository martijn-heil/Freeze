package com.gitlab.martijn_heil.freeze;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Freeze extends JavaPlugin
{
    private static Freeze instance = null;

    public static Freeze getInstance() {
        return instance;
    }

    private static final Map<UUID, Boolean> frozenPlayers = new HashMap<>();

    @Override
    public void onEnable()
    {
        instance = this;
        this.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new MainListener(), this);
        Bukkit.getPluginManager().registerEvents(new FreezeListener(), this);

        this.getCommand("freeze").setExecutor(new FreezeCommand());
        this.getCommand("unfreeze").setExecutor(new UnfreezeCommand());
    }

    public Collection<String> getCommandWhitelist() {
        return this.getConfig().getStringList("command_whitelist");
    }

    public static boolean isFrozen(OfflinePlayer p)
    {
        return frozenPlayers.containsKey(p.getUniqueId());
    }

    public static void setFrozen(OfflinePlayer p, boolean value, boolean silent)
    {
        if(value)
        {
            if(p.isOnline())
            {
                Player player = p.getPlayer();
                Boolean hadAllowFlight = (player != null) ? player.getAllowFlight() : null;
                frozenPlayers.put(p.getUniqueId(), hadAllowFlight);
                p.getPlayer().setAllowFlight(true);
                if(!silent) p.getPlayer().sendMessage(ChatColor.DARK_RED + "You have been frozen! Please wait until a staff member contacts you.");
            }
            else
            {
                frozenPlayers.put(p.getUniqueId(), null);
            }

            if(!silent) Bukkit.broadcast(ChatColor.DARK_RED + p.getName() + " has been frozen!", "freeze.notify");
        }
        else
        {
            Boolean previous = frozenPlayers.remove(p.getUniqueId());
            if(p.getPlayer() != null)
            {
                if(previous != null) p.getPlayer().setAllowFlight(previous);
                if(!silent) p.getPlayer().sendMessage(ChatColor.GREEN + "You have been unfrozen!");
            }

            if(!silent) Bukkit.broadcast(ChatColor.GREEN + p.getName() + " has been unfrozen!", "freeze.notify");
        }
    }

    public static void setFrozen(OfflinePlayer p, boolean value)
    {
        setFrozen(p, value, false);
    }

    private class FreezeListener implements Listener
    {
        @EventHandler(ignoreCancelled = true)
        public void onPlayerJoin(PlayerJoinEvent e)
        {
            if(frozenPlayers.containsKey(e.getPlayer().getUniqueId()))
            {
                if(frozenPlayers.get(e.getPlayer().getUniqueId()) == null)
                {
                    frozenPlayers.put(e.getPlayer().getUniqueId(), e.getPlayer().getAllowFlight());
                }

                e.getPlayer().setAllowFlight(true);
            }
        }
    }
}
