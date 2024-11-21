package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class VillagerRole extends Role {
    public VillagerRole(int maxPlayers) {
        super("Villager", ChatColor.YELLOW, maxPlayers);
    }

    @Override
    public void useAbility(Player player, Player target) {
        player.sendMessage(super.getColor() + "You are a simple villager. You do not have any special abilities.");
    }
}
