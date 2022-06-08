package com.gitlab.martijn_heil.freeze;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;

import java.util.Collection;

public class MainListener implements Listener
{
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerBedEnter(PlayerBedEnterEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerBucketFill(PlayerBucketFillEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerCommandPreProcess(PlayerCommandPreprocessEvent e)
    {
        String command = e.getMessage().substring(1);
        Collection<String> commandWhitelist = Freeze.getInstance().getCommandWhitelist();
        if (commandWhitelist.stream().anyMatch(command::startsWith)) return;

        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDropItem(PlayerDropItemEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerEditBook(PlayerEditBookEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerEggThrow(PlayerEggThrowEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            sendActionDenialMessage(e.getPlayer());
            e.getEgg().remove();
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerFish(PlayerFishEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerItemConsume(PlayerItemConsumeEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerItemHeld(PlayerItemHeldEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerMove(PlayerMoveEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPickupArrow(PlayerPickupArrowEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPickupItem(EntityPickupItemEvent e)
    {
        if (!(e.getEntity() instanceof Player player)) return;

        if(Freeze.isFrozen(player))
        {
            e.setCancelled(true);
        }
    }


    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPortalEvent(PlayerPortalEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerShearEntity(PlayerShearEntityEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerTeleport(PlayerTeleportEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerToggleFlight(PlayerToggleFlightEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerToggleSneak(PlayerToggleSneakEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerToggleSprint(PlayerToggleSprintEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerUnleashEntity(PlayerUnleashEntityEvent e)
    {
        if(Freeze.isFrozen(e.getPlayer()))
        {
            e.setCancelled(true);
            sendActionDenialMessage(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onCraftItem(CraftItemEvent e)
    {
        if(e.getWhoClicked() instanceof Player p)
        {
            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
                p.updateInventory();
                sendActionDenialMessage(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryClick(InventoryClickEvent e)
    {
        if(e.getWhoClicked() instanceof Player p)
        {
            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
                p.updateInventory();
                sendActionDenialMessage(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryCreative(InventoryCreativeEvent e)
    {
        if(e.getWhoClicked() instanceof Player p)
        {

            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
                p.updateInventory();
                sendActionDenialMessage(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryDrag(InventoryDragEvent e)
    {
        if(e.getWhoClicked() instanceof Player p)
        {

            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
                p.updateInventory();
                sendActionDenialMessage(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryMoveItem(InventoryMoveItemEvent e)
    {
        if(e.getInitiator().getHolder() instanceof Player p)
        {

            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
                p.updateInventory();
                sendActionDenialMessage(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerGetHurt(EntityDamageEvent e)
    {
        if(e.getEntity() instanceof Player p)
        {

            if(Freeze.isFrozen(p))
            {
                e.setCancelled(true);
            }
        }
    }



    public void sendActionDenialMessage(Player p)
    {
        p.sendMessage(ChatColor.RED + "You can not do this when frozen!");
    }
}
