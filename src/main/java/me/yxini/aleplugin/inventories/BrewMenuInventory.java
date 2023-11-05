package me.yxini.aleplugin.inventories;

import me.yxini.aleplugin.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class BrewMenuInventory {
    private Inventory inventory;

    public BrewMenuInventory(Player ply) {
        inventory = Bukkit.createInventory(ply, 27, ChatColor.YELLOW+"Ale barrel");
        ItemStack emptySpot = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
        ItemMeta im = emptySpot.getItemMeta();
        im.setDisplayName(" ");
        emptySpot.setItemMeta(im);
        ArrayList<Integer> airSlots = new ArrayList<Integer>();
        airSlots.add(10);airSlots.add(13);airSlots.add(16);
        for (int i = 0; i < 27; i++) {
            if (!airSlots.contains(i)) {
                inventory.setItem(i,emptySpot);
            }
            inventory.setItem(22,new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
