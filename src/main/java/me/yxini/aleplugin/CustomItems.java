package me.yxini.aleplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomItems {
    /**
     * Returns a custom Ale item having (quantity) times the item
     *
     * @param quantity The quantity to be obtained clamps to max stack size
     * @return an ItemStack with the quantity of Ale given
     */
    public static ItemStack getAle(int quantity) {
        quantity = Math.max(0, Math.min(Material.HONEY_BOTTLE.getMaxStackSize(), quantity));
        ItemStack aleStack = new ItemStack(Material.HONEY_BOTTLE,quantity);
        ItemMeta im = aleStack.getItemMeta();
        im.setDisplayName(ChatColor.YELLOW + "Ale");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Don't drink too much!");
        lore.add(ChatColor.DARK_PURPLE + "Or you might black out...");
        im.setLore(lore);
        aleStack.setItemMeta(im);

        return aleStack;
    }

//    public static ItemStack getBarley(int quantity) {
//        quantity = Math.max(0, Math.min(Material.WHEAT.getMaxStackSize(), quantity));
//        ItemStack aleStack = new ItemStack(Material.WHEAT,quantity);
//        ItemMeta im = aleStack.getItemMeta();
//        im.setDisplayName(ChatColor.YELLOW + "Barley");
//        ArrayList<String> lore = new ArrayList<>();
//        lore.add("Used to brew ale.");
//        im.setLore(lore);
//        aleStack.setItemMeta(im);
//
//        return aleStack;
//    }
}
