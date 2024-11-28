package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SeerRole extends Role {
    public SeerRole(int maxPlayers) {
        super("Seer", ChatColor.DARK_AQUA, maxPlayers);
    }

    @Override
    public void useAbility(Player player, Player target) {
        player.sendMessage(super.getColor() + "You are using Seer!");
    }
}
