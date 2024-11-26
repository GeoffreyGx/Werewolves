package com.geoffreygx.werewolves.commands;

import com.geoffreygx.werewolves.Game;
import com.geoffreygx.werewolves.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StartGame implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /startgame <werewolvesCount>");
            return false;
        }

        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "werewolvesCount must be an integer");
            return false;
        }

        int werewolvesCount = Integer.parseInt(args[0]);
        UUID uuid = UUID.randomUUID();

        List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Game game = new Game(uuid, werewolvesCount);
        game.assignRoles(onlinePlayers);

        Plugin.addGame(game);

        return true;
    }
}
