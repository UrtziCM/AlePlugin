package me.yxini.aleplugin.commands;

import me.yxini.aleplugin.inventories.BrewMenuInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BrewCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        assert commandSender instanceof Player;
        Player ply = (Player) commandSender;
        BrewMenuInventory brewInventory = new BrewMenuInventory(ply);

        ply.openInventory(brewInventory.getInventory());

        return true;
    }
}
