package com.geoffreygx.werewolves.commands;

import com.geoffreygx.werewolves.Game;
import com.geoffreygx.werewolves.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class GamesList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        List<Game> games = Plugin.getGames();

        for (Game game : games) {
            commandSender.sendMessage(game.getGameUUID().toString());
        }
        return true;
    }
}
