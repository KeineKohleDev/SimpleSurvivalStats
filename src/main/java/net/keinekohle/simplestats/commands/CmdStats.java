package net.keinekohle.simplestats.commands;

import net.keinekohle.simplestats.config.Language;
import net.keinekohle.simplestats.config.LanguageValues;
import net.keinekohle.simplestats.util.Constance;
import net.keinekohle.simplestats.util.PermissionsList;
import net.keinekohle.simplestats.util.StatsUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class CmdStats implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        if (!(sender instanceof Player)) return false;

            Player player = (Player) sender;

            switch (args.length)
            {
                case 0:
                    if (player.hasPermission(PermissionsList.PERM_PRIVATE_STATS))
                        StatsUtil.createInventory(player, Bukkit.getOfflinePlayer(player.getUniqueId()));
                    else
                        player.sendMessage(Constance.PREFIX +  Language.getInstance().getSetting(LanguageValues.NO_PERM));
                    break;
                case 1:
                    if (player.hasPermission(PermissionsList.PERM_PUBLIC_STATS))
                        StatsUtil.createInventory(player, Bukkit.getOfflinePlayer(args[0]));
                    else
                        player.sendMessage(Constance.PREFIX +  Language.getInstance().getSetting(LanguageValues.NO_PERM));
                    break;
                default:
                    player.sendMessage(Constance.PREFIX + Language.getInstance().getSetting(LanguageValues.STATS_CMD_HELP));
            }
        return true;
    }
}
