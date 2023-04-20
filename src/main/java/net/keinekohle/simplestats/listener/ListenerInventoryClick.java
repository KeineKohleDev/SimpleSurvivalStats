package net.keinekohle.simplestats.listener;

import net.keinekohle.simplestats.config.Language;
import net.keinekohle.simplestats.config.LanguageValues;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ListenerInventoryClick implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        if (event.getView().getTitle().contains(Language.getInstance().getSetting(LanguageValues.INVENTORY_NAME)))
            event.setCancelled(true);
    }
}
