package net.keinekohle.simplestats.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ListenerInventoryClick implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        if (!(event.getWhoClicked() instanceof Player))
            return;

        if (event.getView().getTitle().contains("§6Stats of"))
            event.setCancelled(true);
    }
}
