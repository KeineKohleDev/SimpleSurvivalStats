package net.keinekohle.simplestats.main;

import net.keinekohle.simplestats.commands.CmdStats;
import net.keinekohle.simplestats.listener.ListenerInventoryClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{

    @Override
    public void onEnable ()
    {
        registerEvents();
        registerCommands();
    }

    private void registerEvents()
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ListenerInventoryClick(), this);
    }


    private void registerCommands()
    {
        getCommand("stats").setExecutor(new CmdStats());
    }
}
