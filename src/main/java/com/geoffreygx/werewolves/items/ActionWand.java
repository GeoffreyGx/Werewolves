package com.geoffreygx.werewolves.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ActionWand {
    public static ItemStack getWand() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + "Action Wand");
            meta.setLore(List.of(ChatColor.WHITE + "Use the powers that have been conveyed to you!"));
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        };

        return item;
    }

    public static void giveWand(Player player) {
        player.getInventory().addItem(getWand());
    }
}
