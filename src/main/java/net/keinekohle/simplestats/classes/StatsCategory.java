package net.keinekohle.simplestats.classes;

import net.keinekohle.simplestats.util.ItemBuilder;
import net.keinekohle.simplestats.util.StatsTitels;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class StatsCategory
{
    private int slot;
    private List<String> stats;
    private ItemStack itemStack;

    public StatsCategory (Material icon, int slot, String category, List<String> stats)
    {
        this.slot = slot;
        this.stats = stats;
        paintStats();
        itemStack = ItemBuilder.createItemStackWithLore(icon, 1, category, getStats());
    }

    public void paintStats ()
    {
        for (int i = 0; i < this.getStats().size(); i++)
        {
            if (i % 2 == 0)
                this.getStats().set(i, StatsTitels.FIRST_LINE_COLOR + this.getStats().get(i));
            else
                this.getStats().set(i, StatsTitels.SECOND_LINE_COLOR + this.getStats().get(i));
        }
    }

    public int getSlot ()
    {
        return slot;
    }

    public List<String> getStats ()
    {
        return stats;
    }


    public ItemStack getItemStack ()
    {
        return itemStack;
    }
}
