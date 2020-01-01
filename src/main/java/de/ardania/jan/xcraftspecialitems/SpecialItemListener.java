package de.ardania.jan.xcraftspecialitems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpecialItemListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null) {
            return;
        }
        if (item.getType().equals(Material.AIR)) {
            return;
        }
        if (item.getItemMeta().getDisplayName() == null) {
            return;
        }
        if (item.getEnchantments() == null || item.getEnchantments().isEmpty()) {
            return;
        }
        if (item.getType().equals(Material.CRAFTING_TABLE) &&
                item.getItemMeta().getDisplayName().endsWith("Taschenwerkbank") &&
                item.getEnchantments().containsKey(Enchantment.THORNS)) {
            event.getPlayer().openWorkbench(event.getPlayer().getLocation(), true);
            event.setCancelled(true);
        }
    }
}
