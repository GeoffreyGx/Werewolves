package com.geoffreygx.werewolves;

import com.geoffreygx.werewolves.roles.Role;
import com.geoffreygx.werewolves.roles.VillagerRole;
import com.geoffreygx.werewolves.roles.WerewolfRole;
import org.bukkit.entity.Player;

import java.util.*;

public class Game {
    private final int werewolvesCount;
    private final UUID gameUUID;
    private final String shortenedUUID;
    private final List<Role> roles;

    public Game(UUID gameUUID, int werewolvesCount) {
        this.werewolvesCount = werewolvesCount;
        this.gameUUID = gameUUID;

        this.shortenedUUID = gameUUID.toString().replace("-", "").substring(0, 7);

        WerewolfRole werewolfRole = new WerewolfRole(werewolvesCount);
        VillagerRole villagerRole = new VillagerRole(12 - werewolvesCount);
        this.roles = new ArrayList<>(Arrays.asList(werewolfRole, villagerRole));
    }

    public void assignRoles(List<Player> onlinePlayers) {
        if (onlinePlayers.isEmpty()) {
            throw new IllegalArgumentException("No online players available");
        }

        Collections.shuffle(onlinePlayers);
        List<Player> playersToAssign = new ArrayList<>(onlinePlayers);

        for (Role role : roles) {
            for (Player player : playersToAssign) {
                if (!(role.getMaxPlayers() == role.getPlayerCount())) {
                    role.addPlayer(player);
                    onlinePlayers.remove(player);
                } else {
                    break;
                }
            }
            playersToAssign = new ArrayList<>(onlinePlayers);
        }
    }

    public HashMap showRoles() {
        HashMap<Role, Player> currentPlayers = new HashMap<>();
        for (Role role : roles) {
            for (Player player : role.getPlayers()) {
                currentPlayers.put(role, player);
            }
        }
        return currentPlayers;
    }

    public int getWerewolvesCount() {
        return werewolvesCount;
    }

    public UUID getGameUUID() {
        return gameUUID;
    }
}
