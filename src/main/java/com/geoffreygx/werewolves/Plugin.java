package com.geoffreygx.werewolves;

import com.geoffreygx.werewolves.commands.GamesList;
import com.geoffreygx.werewolves.commands.RolesList;
import com.geoffreygx.werewolves.commands.StartGame;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Plugin extends JavaPlugin {
    private static List<Game> games = new ArrayList<Game>();

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
        games.add(game);
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