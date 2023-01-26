package net.keinekohle.simplestats.util;

import net.keinekohle.simplestats.classes.StatsCategory;
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
        Inventory inventory = Bukkit.createInventory(null, 2 * 9, StatsTitels.INVENTORY_NAME + offlinePlayer.getName());
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
        pvp_pve_stats.add(StatsTitels.DAMAGE_ABSORBED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_ABSORBED));
        pvp_pve_stats.add(StatsTitels.DAMAGE_TAKEN + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_TAKEN));
        pvp_pve_stats.add(StatsTitels.DAMAGE_DEALT + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_DEALT));
        pvp_pve_stats.add(StatsTitels.DAMAGE_BLOCKED_BY_SHIELD + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD));
        pvp_pve_stats.add(StatsTitels.PLAYERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.PLAYER_KILLS));
        pvp_pve_stats.add(StatsTitels.MOBS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.MOB_KILLS));
        pvp_pve_stats.add(StatsTitels.DEATHS + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.DEATHS));
        pvp_pve_stats.add(StatsTitels.RAIDS_TRIGGERED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.RAID_TRIGGER));
        pvp_pve_stats.add(StatsTitels.RAIDS_WON + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.RAID_WIN));
        return new StatsCategory(StatsTitels.PVP_PVE_ICON, StatsTitels.PVP_PVE_SLOT, StatsTitels.PVP_PVE_TITLE, pvp_pve_stats);
    }

    public static StatsCategory createMining (OfflinePlayer offlinePlayer)
    {
        List<String> miningStats = new ArrayList<>();
        miningStats.add(StatsTitels.DIAMONDS + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE)));
        miningStats.add(StatsTitels.IRON + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_IRON_ORE)));
        miningStats.add(StatsTitels.GOLD + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_GOLD_ORE)));
        miningStats.add(StatsTitels.REDSTONE + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_REDSTONE_ORE)));
        miningStats.add(StatsTitels.LABIS + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_LAPIS_ORE)));
        miningStats.add(StatsTitels.COPPER + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.COPPER_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_COPPER_ORE)));
        miningStats.add(StatsTitels.COAL + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE) + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_COAL_ORE)));
        miningStats.add(StatsTitels.ANCIENT + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.ANCIENT_DEBRIS));
        miningStats.add(StatsTitels.QUARTZ + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.NETHER_QUARTZ_ORE));
        miningStats.add(StatsTitels.STONE + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.STONE) +
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
        miningStats.add(StatsTitels.WOOD + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.BIRCH_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.ACACIA_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.JUNGLE_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.DARK_OAK_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.SPRUCE_LOG) +
                offlinePlayer.getStatistic(Statistic.MINE_BLOCK, Material.MANGROVE_LOG)));
        return new StatsCategory(StatsTitels.MINING_ICON, StatsTitels.MINING_SLOT, StatsTitels.MINING_TITLE, miningStats);
    }


    public static StatsCategory createMovement (OfflinePlayer offlinePlayer)
    {
        List<String> movementStats = new ArrayList<>();
        movementStats.add(StatsTitels.JUMPS + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.JUMP));
        movementStats.add(StatsTitels.DISTANCE_WALED + StatsTitels.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.WALK_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_WALKED_UNDER_WATER + StatsTitels.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.WALK_UNDER_WATER_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_SPRINTED +  StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.SPRINT_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_CROUCHED +  StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.CROUCH_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_SWAM + StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.SWIM_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_FALLEN + StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.FALL_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_BY_ELYTRA + StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.FLY_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_BY_BOAT + StatsTitels.SEPARATOR +  Util.cmToKm(offlinePlayer.getStatistic(Statistic.BOAT_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        movementStats.add(StatsTitels.DISTANCE_BY_MINECART + StatsTitels.SEPARATOR + Util.cmToKm(offlinePlayer.getStatistic(Statistic.MINECART_ONE_CM)) + StatsTitels.DISTANCE_IN_KM);
        return new StatsCategory(StatsTitels.MOVEMENT_ICON, StatsTitels.MOVEMENT_SLOT, StatsTitels.MOVEMENT_TITLE, movementStats);
    }

    public static StatsCategory createTime (OfflinePlayer offlinePlayer)
    {
        List<String> movementStats = new ArrayList<>();
        movementStats.add(StatsTitels.TIME_PLAYED + StatsTitels.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.PLAY_ONE_MINUTE)) + StatsTitels.TIME_IN_M);
        movementStats.add(StatsTitels.TIME_SINCE_LAST_DEATH + StatsTitels.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.TIME_SINCE_DEATH)) + StatsTitels.TIME_IN_M);
        movementStats.add(StatsTitels.TIME_SNEAKED + StatsTitels.SEPARATOR + Util.ticksToMin(offlinePlayer.getStatistic(Statistic.SNEAK_TIME)) + StatsTitels.TIME_IN_M);
        return new StatsCategory(StatsTitels.TIME_ICON, StatsTitels.TIME_SLOT, StatsTitels.TIME_TITLE, movementStats);
    }

    public static StatsCategory createAnimals (OfflinePlayer offlinePlayer)
    {
        List<String> animalStats = new ArrayList<>();
        animalStats.add(StatsTitels.ANIMALS_BRED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.ANIMALS_BRED));
        animalStats.add(StatsTitels.COWS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COW));
        animalStats.add(StatsTitels.PIGS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PIG));
        animalStats.add(StatsTitels.SHEEP_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SHEEP));
        animalStats.add(StatsTitels.CHICKENS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CHICKEN));
        animalStats.add(StatsTitels.HORSES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.HORSE));
        animalStats.add(StatsTitels.LLAMAS_KILLED + StatsTitels.SEPARATOR + (
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.LLAMA) +
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.LLAMA_SPIT) +
                        offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.TRADER_LLAMA)));
        animalStats.add(StatsTitels.PANDAS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PANDA));
        animalStats.add(StatsTitels.RABBITS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.RABBIT));
        animalStats.add(StatsTitels.WOLFS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WOLF));
        animalStats.add(StatsTitels.OCELOTS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.OCELOT));
        animalStats.add(StatsTitels.CATS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CAT));
        animalStats.add(StatsTitels.FISH_KILLED + StatsTitels.SEPARATOR + (offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COD) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.HUSK) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SALMON) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.TROPICAL_FISH) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PUFFERFISH) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.COD)));
        animalStats.add(StatsTitels.AXOLOTLS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.AXOLOTL));
        animalStats.add(StatsTitels.FOXES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.FOX));
        animalStats.add(StatsTitels.SQUIDS_KILLED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SQUID) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GLOW_SQUID)));
        animalStats.add(StatsTitels.MULES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.MULE));
        animalStats.add(StatsTitels.DONKEYS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.DONKEY));
        animalStats.add(StatsTitels.GOATS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GOAT));
        animalStats.add(StatsTitels.PARROTS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PARROT));
        return new StatsCategory(StatsTitels.ANIMALS_ICON, StatsTitels.ANIMALS_SLOT, StatsTitels.ANIMALS_TITLE, animalStats);
    }


    public static StatsCategory createMobs (OfflinePlayer offlinePlayer)
    {
        List<String> mobStats = new ArrayList<>();
        mobStats.add(StatsTitels.ZOMBIES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ZOMBIE));
        mobStats.add(StatsTitels.DROWNEDS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.DROWNED));
        mobStats.add(StatsTitels.PIGLINS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PIGLIN));
        mobStats.add(StatsTitels.SKELETONS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SKELETON));
        mobStats.add(StatsTitels.WITHER_SKELETONS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER_SKELETON));
        mobStats.add(StatsTitels.CREEPERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CREEPER));
        mobStats.add(StatsTitels.SPIDERS_KILLED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SPIDER) +
                offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.CAVE_SPIDER)));
        mobStats.add(StatsTitels.PHANTOMS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.PHANTOM));
        mobStats.add(StatsTitels.ELDER_GUARDIANS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ELDER_GUARDIAN));
        mobStats.add(StatsTitels.GUARDIANS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GUARDIAN));
        mobStats.add(StatsTitels.SHULKERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SHULKER));
        mobStats.add(StatsTitels.SLIMES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.SLIME));
        mobStats.add(StatsTitels.MAGMA_CUBS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.MAGMA_CUBE));
        mobStats.add(StatsTitels.BLAZES_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.BLAZE));
        mobStats.add(StatsTitels.GHASTS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.GHAST));
        mobStats.add(StatsTitels.EVOKERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.EVOKER));
        mobStats.add(StatsTitels.VINDICATORS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.VINDICATOR));
        mobStats.add(StatsTitels.RAVAGERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.RAVAGER));
        mobStats.add(StatsTitels.ENDER_DRAGONS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON));
        mobStats.add(StatsTitels.WHITHERS_KILLED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER));
        return new StatsCategory(StatsTitels.MOBS_ICON, StatsTitels.MOBS_SLOT, StatsTitels.MOBS_TITLE, mobStats);
    }


    public static StatsCategory createBlocksPlaced (OfflinePlayer offlinePlayer)
    {
        List<String> blocksPlacedStats = new ArrayList<>();
        blocksPlacedStats.add(StatsTitels.WOOD_PLACED + StatsTitels.SEPARATOR + (
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
        blocksPlacedStats.add(StatsTitels.STONE_PLACED + StatsTitels.SEPARATOR + (
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
        blocksPlacedStats.add(StatsTitels.DIRT_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COARSE_DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ROOTED_DIRT) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DIRT_PATH) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GRASS_BLOCK) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PODZOL)));
        blocksPlacedStats.add(StatsTitels.SAND_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SAND) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.RED_SAND) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SANDSTONE)));
        blocksPlacedStats.add(StatsTitels.GLASS_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GLASS) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.GLASS_PANE) +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "STAINED_GLASS") +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "STAINED_GLASS_PANE")));
        blocksPlacedStats.add(StatsTitels.CONCRETE_PLACED + StatsTitels.SEPARATOR + (
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "CONCRETE") +
                 getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "CONCRETE_POWDER")));
        blocksPlacedStats.add(StatsTitels.FENCES_PLACED + StatsTitels.SEPARATOR + (
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
        blocksPlacedStats.add(StatsTitels.FLOWERS_PLACED + StatsTitels.SEPARATOR + (
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
        blocksPlacedStats.add(StatsTitels.CHESTS_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CHEST) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ENDER_CHEST) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.TRAPPED_CHEST)));
        blocksPlacedStats.add(StatsTitels.FURNACES_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.FURNACE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BLAST_FURNACE) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SMOKER)));
        blocksPlacedStats.add(StatsTitels.CRAFTING_TABLES_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.CRAFTING_TABLE));
        blocksPlacedStats.add(StatsTitels.BEE_NESTS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.BEE_NEST));
        blocksPlacedStats.add(StatsTitels.BANNERS_PLACED + StatsTitels.SEPARATOR + (
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "BANNER") +
                getAmountForAllColors(offlinePlayer, Statistic.USE_ITEM, "WALL_BANNER")));
        blocksPlacedStats.add(StatsTitels.LIGHT_SOURCES_PLACED + StatsTitels.SEPARATOR + (
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
        return new StatsCategory(StatsTitels.BLOCKS_PLACED_ICON, StatsTitels.BLOCKS_PLACED_SLOT, StatsTitels.BLOCKS_PLACED_TITLE, blocksPlacedStats);
    }

    public static StatsCategory createRedStone (OfflinePlayer offlinePlayer)
    {
        List<String> redStoneStats = new ArrayList<>();
        redStoneStats.add(StatsTitels.REDSTONE_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REDSTONE));
        redStoneStats.add(StatsTitels.REDSTONE_TORCHES_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REDSTONE_TORCH));
        redStoneStats.add(StatsTitels.REPEATERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.REPEATER));
        redStoneStats.add(StatsTitels.COMPARATORS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.COMPARATOR));
        redStoneStats.add(StatsTitels.PISTONS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.PISTON));
        redStoneStats.add(StatsTitels.STICKY_PISTONS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.STICKY_PISTON));
        redStoneStats.add(StatsTitels.OBSERVERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.OBSERVER));
        redStoneStats.add(StatsTitels.HOPPERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.HOPPER));
        redStoneStats.add(StatsTitels.DISPENSERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DISPENSER));
        redStoneStats.add(StatsTitels.DROPPERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DROPPER));
        redStoneStats.add(StatsTitels.LEVERS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.LEVER));
        redStoneStats.add(StatsTitels.BUTTONS_PLACED + StatsTitels.SEPARATOR + (
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
        redStoneStats.add(StatsTitels.PRESSURE_PLATES_PLACED + StatsTitels.SEPARATOR + (
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
        redStoneStats.add(StatsTitels.SLIME_BLOCKS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.SLIME_BLOCK));
        redStoneStats.add(StatsTitels.HONEY_BLOCKS_PLACED + StatsTitels.SEPARATOR + offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.HONEY_BLOCK));
        redStoneStats.add(StatsTitels.RAILS_PLACED + StatsTitels.SEPARATOR + (
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.ACTIVATOR_RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.DETECTOR_RAIL) +
                offlinePlayer.getStatistic(Statistic.USE_ITEM, Material.POWERED_RAIL)));
        return new StatsCategory(StatsTitels.REDSTONE_ICON, StatsTitels.REDSTONE_SLOT, StatsTitels.REDSTONE_TITLE, redStoneStats);
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
