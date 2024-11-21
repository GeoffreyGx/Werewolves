package com.geoffreygx.werewolves.roles;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WerewolfRole extends Role {
    public WerewolfRole(int maxPlayers) {
        super("Werewolf", ChatColor.DARK_RED, maxPlayers);
    }

    @Override
    public void useAbility(Player player, Player target) {
        target.sendMessage(ChatColor.RED + "You have been killed by " + super.getColor() + ChatColor.ITALIC + player.getName() + ".");
        target.setHealth(0.0D);
        player.sendMessage("You have successfully killed " + player.getName() + ".");
    }
}
