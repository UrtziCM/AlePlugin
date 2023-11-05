package me.yxini.aleplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AleDrinkListener implements Listener {
    @EventHandler
    public void onDrinkAle(PlayerItemConsumeEvent event) {
        ItemMeta im = event.getItem().getItemMeta();
        if (im == null) return;
        if (im.getDisplayName().equals(ChatColor.YELLOW + "Ale")) {
            Player ply = event.getPlayer();
            ply.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 1));
            ply.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 2));
            ply.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
        }
    }
}
