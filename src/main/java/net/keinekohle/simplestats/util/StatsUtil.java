package net.keinekohle.simplestats.util;

import net.keinekohle.simplestats.classes.StatsCategory;
import net.keinekohle.simplestats.config.Language;
import net.keinekohle.simplestats.config.LanguageValues;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class StatsUtil
{
    public static void createInventory (Player player, OfflinePlayer offlinePlayer)
    {
        Inventory inventory = Bukkit.createInventory(null, 2 * 9, Language.getInstance().getSetting(LanguageValues.INVENTORY_NAME) + " " +  offlinePlayer.getName());
        inventory.setItem(4, ItemBuilder.createPlayerHead(offlinePlayer.getUniqueId()));
        StatsCategory pvp_pve_stats = createPvP_PvE(offlinePlayer);
        inventory.setItem(pvp_pve_stats.getSlot(), pvp_pve_stats.getItemStack());
        StatsCategory miningStats = createMining(offlinePlayer);
        inventory.setItem(miningStats.getSlot(), miningStats.getItemStack());
        StatsCategory movementStats = createMovement(offlinePlayer);
        inventory.setItem(movementStats.getSlot(), movementStats.getItemStack());
        StatsCategory timeStats = createTime(offlinePlayer);
        inventory.setItem(timeStats.getSlot(), timeStats.getItemStack());
        StatsCategory animalStats  = createAnimals(offlinePlayer);
        inventory.setItem(animalStats.getSlot(), animalStats.getItemStack());
        StatsCategory mobStats  = createMobs(offlinePlayer);
        inventory.setItem(mobStats.getSlot(), mobStats.getItemStack());
        StatsCategory blocksPlacedStats  = createBlocksPlaced(offlinePlayer);
        inventory.setItem(blocksPlacedStats.getSlot(), blocksPlacedStats.getItemStack());
        StatsCategory redStoneStats  = createRedStone(offlinePlayer);
        inventory.setItem(redStoneStats.getSlot(), redStoneStats.getItemStack());
        player.openInventory(inventory);
    }
    public static StatsCategory createPvP_PvE (OfflinePlayer offlinePlayer)
    {
        List<String> pvp_pve_stats = new ArrayList<>();
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.DAMAGE_ABSORBED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_ABSORBED));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.DAMAGE_TAKEN) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_TAKEN));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.DAMAGE_DEALT) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_DEALT));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.DAMAGE_BLOCKED_BY_SHIELD) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.PLAYERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.PLAYER_KILLS));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.MOBS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.MOB_KILLS));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.DEATHS) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.DEATHS));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.RAIDS_TRIGGERED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.RAID_TRIGGER));
        pvp_pve_stats.add(Language.getInstance().getSetting(LanguageValues.RAIDS_WON) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.RAID_WIN));
        return new StatsCategory(Constance.PVP_PVE_ICON, Constance.PVP_PVE_SLOT, Language.getInstance().getSetting(LanguageValues.PVP_PVE_TITLE), pvp_pve_stats);
    }

    public static StatsCategory createMining (OfflinePlayer offlinePlayer)
    {
        List<String> miningStats = new ArrayList<>();
        miningStats.add(Language.getInstance().getSetting(LanguageValues.DIAMONDS) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.IRON) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_IRON_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.GOLD) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_GOLD_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.REDSTONE) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_REDSTONE_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.LABIS) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_LAPIS_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.COPPER) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.COPPER_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_COPPER_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.COAL) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_COAL_ORE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.ANCIENT) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.ANCIENT_DEBRIS));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.QUARTZ) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.NETHER_QUARTZ_ORE));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.STONE) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.STONE) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.COBBLESTONE) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.NETHERRACK) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.SAND) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.GRAVEL) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DIRT) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.GRANITE) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.ANDESITE) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DIORITE)));
        miningStats.add(Language.getInstance().getSetting(LanguageValues.WOOD) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.BIRCH_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.ACACIA_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.JUNGLE_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DARK_OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.SPRUCE_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.MANGROVE_LOG)));
        return new StatsCategory(Constance.MINING_ICON, Constance.MINING_SLOT, Language.getInstance().getSetting(LanguageValues.MINING_TITLE), miningStats);
    }


    public static StatsCategory createMovement (OfflinePlayer offlinePlayer)
    {
        List<String> movementStats = new ArrayList<>();
        movementStats.add(Language.getInstance().getSetting(LanguageValues.JUMPS) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.JUMP));
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_WALED) + Constance.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.WALK_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_WALKED_UNDER_WATER) + Constance.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.WALK_UNDER_WATER_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_SPRINTED) + Constance.SEPARATOR  + Util.cmToKm(offlinePlayer.getStatistic(Statistic.SPRINT_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_CROUCHED) + Constance.SEPARATOR  + Util.cmToKm(offlinePlayer.getStatistic(Statistic.CROUCH_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_SWAM) + Constance.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.SWIM_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_FALLEN) + Constance.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.FALL_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_BY_ELYTRA) + Constance.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.FLY_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_BY_BOAT) + Constance.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.BOAT_ONE_CM)) + Constance.DISTANCE_IN_KM);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.DISTANCE_BY_MINECART) + Constance.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.MINECART_ONE_CM)) + Constance.DISTANCE_IN_KM);
        return new StatsCategory(Constance.MOVEMENT_ICON, Constance.MOVEMENT_SLOT, Language.getInstance().getSetting(LanguageValues.MOVEMENT_TITLE), movementStats);
    }

    public static StatsCategory createTime (OfflinePlayer offlinePlayer)
    {
        List<String> movementStats = new ArrayList<>();
        movementStats.add(Language.getInstance().getSetting(LanguageValues.TIME_PLAYED) + Constance.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.PLAY_ONE_MINUTE)) + Constance.TIME_IN_M);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.TIME_SINCE_LAST_DEATH) + Constance.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.TIME_SINCE_DEATH)) + Constance.TIME_IN_M);
        movementStats.add(Language.getInstance().getSetting(LanguageValues.TIME_SNEAKED) + Constance.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.SNEAK_TIME)) + Constance.TIME_IN_M);
        return new StatsCategory(Constance.TIME_ICON, Constance.TIME_SLOT, Language.getInstance().getSetting(LanguageValues.TIME_TITLE), movementStats);
    }

    public static StatsCategory createAnimals (OfflinePlayer offlinePlayer)
    {
        List<String> animalStats = new ArrayList<>();
        animalStats.add(Language.getInstance().getSetting(LanguageValues.ANIMALS_BRED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.ANIMALS_BRED));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.COWS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COW));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.PIGS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PIG));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.SHEEP_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SHEEP));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.CHICKENS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CHICKEN));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.HORSES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.HORSE));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.LLAMAS_KILLED) + Constance.SEPARATOR + (
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.LLAMA) +
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.LLAMA_SPIT) +
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.TRADER_LLAMA)));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.PANDAS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PANDA));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.RABBITS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.RABBIT));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.WOLFS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WOLF));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.OCELOTS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.OCELOT));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.CATS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CAT));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.FISH_KILLED) + Constance.SEPARATOR + (offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COD) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.HUSK) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SALMON) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.TROPICAL_FISH) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PUFFERFISH) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COD)));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.AXOLOTLS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.AXOLOTL));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.FOXES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.FOX));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.SQUIDS_KILLED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SQUID) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GLOW_SQUID)));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.MULES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.MULE));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.DONKEYS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.DONKEY));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.GOATS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GOAT));
        animalStats.add(Language.getInstance().getSetting(LanguageValues.PARROTS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PARROT));
        return new StatsCategory(Constance.ANIMALS_ICON, Constance.ANIMALS_SLOT, Language.getInstance().getSetting(LanguageValues.ANIMALS_TITLE), animalStats);
    }


    public static StatsCategory createMobs (OfflinePlayer offlinePlayer)
    {
        List<String> mobStats = new ArrayList<>();
        mobStats.add(Language.getInstance().getSetting(LanguageValues.ZOMBIES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ZOMBIE));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.DROWNEDS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.DROWNED));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.PIGLINS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PIGLIN));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.SKELETONS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SKELETON));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.WITHER_SKELETONS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER_SKELETON));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.CREEPERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CREEPER));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.SPIDERS_KILLED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SPIDER) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CAVE_SPIDER)));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.PHANTOMS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PHANTOM));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.ELDER_GUARDIANS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ELDER_GUARDIAN));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.GUARDIANS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GUARDIAN));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.SHULKERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SHULKER));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.SLIMES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SLIME));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.MAGMA_CUBS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.MAGMA_CUBE));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.BLAZES_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.BLAZE));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.GHASTS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GHAST));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.EVOKERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.EVOKER));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.VINDICATORS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.VINDICATOR));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.RAVAGERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.RAVAGER));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.ENDER_DRAGONS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON));
        mobStats.add(Language.getInstance().getSetting(LanguageValues.WHITHERS_KILLED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER));
        return new StatsCategory(Constance.MOBS_ICON, Constance.MOBS_SLOT, Language.getInstance().getSetting(LanguageValues.MOBS_TITLE), mobStats);
    }


    public static StatsCategory createBlocksPlaced (OfflinePlayer offlinePlayer)
    {
        List<String> blocksPlacedStats = new ArrayList<>();
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.WOOD_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_STEM) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_STEM) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_ACACIA_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_BIRCH_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_DARK_OAK_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_JUNGLE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_MANGROVE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_OAK_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_SPRUCE_WOOD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_CRIMSON_STEM) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_WARPED_STEM) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_ACACIA_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_BIRCH_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_DARK_OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_JUNGLE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_MANGROVE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STRIPPED_SPRUCE_LOG) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_PLANKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_PLANKS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_SLAB) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_STAIRS) +
                        offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_STAIRS)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.STONE_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLESTONE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLESTONE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLESTONE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GRANITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GRANITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GRANITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_GRANITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_GRANITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_GRANITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ANDESITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ANDESITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ANDESITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_ANDESITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_ANDESITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_ANDESITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIORITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIORITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIORITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DIORITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DIORITE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DIORITE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DEEPSLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DEEPSLATE_BRICK_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DEEPSLATE_BRICK_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DEEPSLATE_TILE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DEEPSLATE_TILE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DEEPSLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DEEPSLATE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_DEEPSLATE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLED_DEEPSLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLED_DEEPSLATE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COBBLED_DEEPSLATE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLACKSTONE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLACKSTONE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLACKSTONE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_BRICK_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_BRICK_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BASALT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BASALT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CALCITE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.TUFF) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DRIPSTONE_BLOCK) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BRICK) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BRICK_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BRICK_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_BRICKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_BRICK_SLAB) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_BRICK_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MUD) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MUD_BRICK_STAIRS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MUD_BRICKS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MUD_BRICK_WALL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MUD_BRICK_SLAB)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.DIRT_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COARSE_DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ROOTED_DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIRT_PATH) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GRASS_BLOCK) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PODZOL)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.SAND_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SAND) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.RED_SAND) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SANDSTONE)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.GLASS_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GLASS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GLASS_PANE) +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "STAINED_GLASS") +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "STAINED_GLASS_PANE")));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.CONCRETE_PLACED) + Constance.SEPARATOR + (
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "CONCRETE") +
                 getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "CONCRETE_POWDER")));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.FENCES_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_FENCE_GATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_FENCE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_FENCE_GATE)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.FLOWERS_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DANDELION) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POPPY) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLUE_ORCHID) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ALLIUM) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.AZURE_BLUET) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ORANGE_TULIP) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PINK_TULIP) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WHITE_TULIP) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.RED_TULIP) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OXEYE_DAISY) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CORNFLOWER) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LILY_OF_THE_VALLEY) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WITHER_ROSE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LILAC) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ROSE_BUSH) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PEONY) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SUNFLOWER)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.CHESTS_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CHEST) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ENDER_CHEST) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.TRAPPED_CHEST)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.FURNACES_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.FURNACE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLAST_FURNACE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SMOKER)));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.CRAFTING_TABLES_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRAFTING_TABLE));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.BEE_NESTS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BEE_NEST));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.BANNERS_PLACED) + Constance.SEPARATOR + (
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "BANNER") +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "WALL_BANNER")));
        blocksPlacedStats.add(Language.getInstance().getSetting(LanguageValues.LIGHT_SOURCES_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.TORCH) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GLOWSTONE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CAMPFIRE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SOUL_CAMPFIRE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LANTERN) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JACK_O_LANTERN) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SEA_LANTERN) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SOUL_LANTERN) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CANDLE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CANDLE_CAKE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REDSTONE_LAMP) +
                getAmountForAllColors (offlinePlayer, Statistic.USE_ITEM, "CANDLE") +
                getAmountForAllColors (offlinePlayer, Statistic.USE_ITEM, "CANDLE_CAKE")));
        return new StatsCategory(Constance.BLOCKS_PLACED_ICON, Constance.BLOCKS_PLACED_SLOT, Language.getInstance().getSetting(LanguageValues.BLOCKS_PLACED_TITLE), blocksPlacedStats);
    }

    public static StatsCategory createRedStone (OfflinePlayer offlinePlayer)
    {
        List<String> redStoneStats = new ArrayList<>();
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.REDSTONE_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REDSTONE));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.REDSTONE_TORCHES_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REDSTONE_TORCH));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.REPEATERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REPEATER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.COMPARATORS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COMPARATOR));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.PISTONS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PISTON));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.STICKY_PISTONS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STICKY_PISTON));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.OBSERVERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OBSERVER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.HOPPERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.HOPPER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.DISPENSERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DISPENSER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.DROPPERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DROPPER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.LEVERS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LEVER));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.BUTTONS_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACACIA_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_BUTTON) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_BUTTON)));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.PRESSURE_PLATES_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BIRCH_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DARK_OAK_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.JUNGLE_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.MANGROVE_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OAK_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SPRUCE_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.WARPED_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRIMSON_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POLISHED_BLACKSTONE_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.HEAVY_WEIGHTED_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LIGHT_WEIGHTED_PRESSURE_PLATE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STONE_PRESSURE_PLATE)));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.SLIME_BLOCKS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SLIME_BLOCK));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.HONEY_BLOCKS_PLACED) + Constance.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.HONEY_BLOCK));
        redStoneStats.add(Language.getInstance().getSetting(LanguageValues.RAILS_PLACED) + Constance.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACTIVATOR_RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DETECTOR_RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POWERED_RAIL)));
        return new StatsCategory(Constance.REDSTONE_ICON, Constance.REDSTONE_SLOT, Language.getInstance().getSetting(LanguageValues.REDSTONE_TITLE), redStoneStats);
    }

    private static int getAmountForAllColors (OfflinePlayer offlinePlayer, Statistic statistic, String baseMaterial)
    {
        int amount = 0;
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("WHITE_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("ORANGE_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("MAGENTA_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("LIGHT_BLUE_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("YELLOW_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("LIME_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("PINK_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("GRAY_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("LIGHT_GRAY_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("CYAN_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("PURPLE_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("BLUE_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("BROWN_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("GREEN_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("RED_" + baseMaterial));
        amount += offlinePlayer.getStatistic(statistic, Material.valueOf("BLACK_" + baseMaterial));
        return amount;
    }
}
