package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CupidRole extends Role {
    public CupidRole(int maxPlayers) {
        super("Cupid", ChatColor.LIGHT_PURPLE, maxPlayers);
    }

    @Override
    public void useAbility(Player player, Player target) {
        player.sendMessage("You are now using Cupid!");
    }
}
