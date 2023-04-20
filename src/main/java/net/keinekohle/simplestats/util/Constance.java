package net.keinekohle.simplestats.util;

import net.keinekohle.simplestats.main.Main;
import org.bukkit.Material;

public class Constance
{
    public static final String PREFIX = "§7[§bSimpleSurvivalStats§7]§f > ";
    public static final String LANG_FILE_NAME = "language.yml";
    public static final String PATH_DELIMITER = "/";
    public static final String PATH_TO_LANG_FILE = Main.getPlugin(Main.class).getDataFolder() + PATH_DELIMITER + LANG_FILE_NAME;
    public static final String FIRST_LINE_COLOR = "§7";
    public static final String SECOND_LINE_COLOR = "§8";
    public static final String DISTANCE_IN_KM = " km";
    public static final String TIME_IN_M = " min";
    public static final String SEPARATOR = ": ";
    /* PvP/PvE category */
    public static final Material PVP_PVE_ICON = Material.IRON_SWORD;
    public static final int PVP_PVE_SLOT = 9;

    /* Mining category */
    public static final Material MINING_ICON = Material.NETHERITE_PICKAXE;
    public static final int MINING_SLOT = 10;

    /* Blocks placed category */

    public static final Material BLOCKS_PLACED_ICON = Material.GRASS_BLOCK;
    public static final int BLOCKS_PLACED_SLOT = 11;

    /* Redstone category */
    public static final Material REDSTONE_ICON = Material.REDSTONE;
    public static final int REDSTONE_SLOT = 14;

    /* Movement category */
    public static final Material MOVEMENT_ICON = Material.GOLDEN_BOOTS;
    public static final int MOVEMENT_SLOT = 12;

    /* Time category */
    public static final Material TIME_ICON = Material.CLOCK;
    public static final int TIME_SLOT = 15;

    /* Animals category */
    public static final Material ANIMALS_ICON = Material.PIG_SPAWN_EGG;
    public static final int ANIMALS_SLOT = 16;

    /* Mobs category */

    public static final Material MOBS_ICON = Material.ZOMBIE_SPAWN_EGG;
    public static final int MOBS_SLOT = 17;
}
