package me.yxini.aleplugin.listeners;

import me.yxini.aleplugin.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

public class BrewMenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.YELLOW + "Ale barrel")) {
            Inventory topInventory = event.getView().getTopInventory();
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE && event.getClickedInventory() == topInventory) {
                event.setCancelled(true);
            }
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.YELLOW_STAINED_GLASS_PANE && event.getClickedInventory() == topInventory) {
                if (shouldCraftAle(topInventory))
                    craftAle(topInventory);
                event.setCancelled(true);
            }
        }
    }

    private boolean shouldCraftAle(Inventory inv) {
        if (inv.getItem(16) != null) return false;
        if (inv.getItem(10) == null || inv.getItem(13) == null) return false;
        if (inv.getItem(10).getType() == Material.WHEAT && inv.getItem(13).getType() == Material.GLASS_BOTTLE){
            return true;
        }
        return false;
    }

    private static void craftAle(Inventory inv) {
        int barleyAmount = inv.getItem(10).getAmount();
        int bottleAmount = inv.getItem(13).getAmount();
        int maxToGive = Math.max(1, Math.min(16, Math.min(barleyAmount,bottleAmount)));
        inv.setItem(10, new ItemStack(Material.WHEAT,barleyAmount - maxToGive));
        inv.setItem(13, new ItemStack(Material.GLASS_BOTTLE, bottleAmount - maxToGive));
        inv.setItem(16, CustomItems.getAle(maxToGive));
    }
}

