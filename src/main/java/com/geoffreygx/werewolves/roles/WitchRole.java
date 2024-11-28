package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WitchRole extends Role {
    public WitchRole(int maxPlayers) {
        super("Witch", ChatColor.DARK_PURPLE, maxPlayers);
    }

    @Override
    public void useAbility(Player player, Player target) {
        player.sendMessage(super.getColor() + "You are now using Witch!");
    }
}
