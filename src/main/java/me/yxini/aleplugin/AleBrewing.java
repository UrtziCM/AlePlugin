package me.yxini.aleplugin;

import me.yxini.aleplugin.commands.BrewCommand;
import me.yxini.aleplugin.listeners.AleDrinkListener;
import me.yxini.aleplugin.listeners.BrewMenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AleBrewing extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[AleBrewingPlugin] Loading plugin");
        getServer().getPluginManager().registerEvents(new BrewMenuListener(), this);
        getServer().getPluginManager().registerEvents(new AleDrinkListener(), this);
        getCommand("barrel").setExecutor(new BrewCommand());
    }
}
