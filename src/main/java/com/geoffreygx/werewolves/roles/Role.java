package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public abstract class Role {
    private final String name;
    private final ChatColor color;
    private final Set<Player> players;
    private int maxPlayers;


    public Role(String name, ChatColor color, int maxPlayers) {
        this.name = name;
        this.color = color;
        this.players = new HashSet<>();
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public Set<Player> getPlayers() {
        return new HashSet<>(players);
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.sendMessage(ChatColor.GOLD + "You are a " + color + name + ChatColor.GOLD + " from now on.");
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void removeAllPlayers() {
        players.clear();
    }

    public abstract void useAbility(Player player, Player target);
}
