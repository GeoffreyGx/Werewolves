package com.geoffreygx.werewolves.commands;

import com.geoffreygx.werewolves.Game;
import com.geoffreygx.werewolves.Plugin;
import com.geoffreygx.werewolves.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class RolesList implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /roleslist <gameUUID>");
            return false;
        }
        UUID gameUUID = UUID.fromString(args[0]);
        try {
            Plugin.getGameFromUUID(gameUUID);
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "Could not find game or UUID is not valid");
        }
        Game game = Plugin.getGameFromUUID(gameUUID);

        HashMap<Role, Player> playingPlayers = game.showRoles();

        // Group players by role
        HashMap<Role, List<String>> rolePlayers = new HashMap<>();
        for (Map.Entry<Role, Player> entry : playingPlayers.entrySet()) {
            Role role = entry.getKey();
            Player player = entry.getValue();

            rolePlayers.computeIfAbsent(role, k -> new ArrayList<>()).add(player.getName());
        }

        // Display the roles and associated players
        for (Map.Entry<Role, List<String>> entry : rolePlayers.entrySet()) {
            Role role = entry.getKey();
            List<String> players = entry.getValue();

            sender.sendMessage(role.getColor() + role.getName() + ":");
            for (String playerName : players) {
                sender.sendMessage(ChatColor.GRAY + "- " + playerName);
            }
        }

        return true;
    }
}
