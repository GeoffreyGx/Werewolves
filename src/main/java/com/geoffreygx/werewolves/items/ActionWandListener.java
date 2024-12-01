package com.geoffreygx.werewolves.items;

import com.geoffreygx.werewolves.Game;
import com.geoffreygx.werewolves.Plugin;
import com.geoffreygx.werewolves.roles.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ActionWandListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            Game game = Plugin.getGameFromPlayer(player);
            Role role = game.getPlayerRole(player);

            ItemStack item = event.getItem();
            if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                if (item.getItemMeta().getDisplayName().equals("Action Wand")) {
                    role.useAbility(player, player);
                }
            }
        }
    }
}
