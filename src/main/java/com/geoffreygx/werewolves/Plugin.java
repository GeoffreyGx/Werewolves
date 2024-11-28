package com.geoffreygx.werewolves;

import com.geoffreygx.werewolves.commands.GamesList;
import com.geoffreygx.werewolves.commands.RolesList;
import com.geoffreygx.werewolves.commands.StartGame;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Plugin extends JavaPlugin {
    private static List<Game> games = new ArrayList<Game>();
    private static Map<String, UUID> shortenedUUIDMap = new HashMap<>();

    @Override
    public void onEnable() {
        this.getCommand("startgame").setExecutor(new StartGame());
        this.getCommand("gameslist").setExecutor(new GamesList());
        this.getCommand("roleslist").setExecutor(new RolesList());
        getLogger().info("Plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    public static List<Game> getGames() {
        return games;
    }

    public static void addGame(Game game) {
        String shortenedUUID = game.getGameUUID().toString().substring(0, 7);
        shortenedUUIDMap.put(shortenedUUID, game.getGameUUID());
        games.add(game);
    }

    public static UUID resolveUUID(String shortenedUUID) {
        return shortenedUUIDMap.get(shortenedUUID);
    }

    public static Game getGameFromUUID(UUID uuid) {
        for (Game game : games) {
            if (game.getGameUUID().equals(uuid)) {
                return game;
            }
        }
        return null;
    }
}