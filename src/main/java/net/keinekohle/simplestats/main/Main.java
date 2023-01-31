package net.keinekohle.simplestats.main;

import net.keinekohle.simplestats.commands.CmdStats;
import net.keinekohle.simplestats.config.Language;
import net.keinekohle.simplestats.listener.ListenerInventoryClick;
import net.keinekohle.simplestats.util.Constance;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.CustomChart;
import org.bstats.charts.SingleLineChart;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Main extends JavaPlugin
{

    @Override
    public void onEnable ()
    {
        // Create language config
        Language.getInstance();
        registerEvents();
        registerCommands();

        authorMessage();

        // Register statistics for this plugin
        Metrics metrics = new Metrics(this, 17598);
        metrics.addCustomChart(new SingleLineChart("offline_players", () -> Math.toIntExact(Arrays.stream(Bukkit.getOfflinePlayers()).filter(offlinePlayer -> offlinePlayer.getName() != null).count())));
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

    private void authorMessage ()
    {
        Bukkit.getConsoleSender().sendMessage(Constance.PREFIX + "§bPlugin developed by KeineKohleDev");
        Bukkit.getConsoleSender().sendMessage(Constance.PREFIX + "§bVersion: 1.2");
        Bukkit.getConsoleSender().sendMessage(Constance.PREFIX + "§b§nDon't forget to rate the Plugin on Spigot!");
        Bukkit.getConsoleSender().sendMessage(Constance.PREFIX + "§bhttps://www.spigotmc.org/resources/simple-survival-stats-1-19.107541/");
    }
}
