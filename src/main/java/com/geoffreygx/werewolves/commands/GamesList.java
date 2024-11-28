package com.geoffreygx.werewolves.commands;

import com.geoffreygx.werewolves.Game;
import com.geoffreygx.werewolves.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class GamesList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        List<Game> games = Plugin.getGames();

        if (games.size() == 0) {
            commandSender.sendMessage(ChatColor.RED + "There are no games in this world.");
            return false;
        }

        commandSender.sendMessage(ChatColor.GREEN + "There are " + games.size() + " active games in this world :");

        for (Game game : games) {
            String truncatedUUID = game.getGameUUID().toString().substring(0, 7);
            commandSender.sendMessage(truncatedUUID);
        }
        return true;
    }
}
