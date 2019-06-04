package me.eccentric_nz.chemistry.product;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;

public class GlowStickRunnable implements Runnable {

    private final Chemistry plugin;

    public GlowStickRunnable(Chemistry plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            PlayerInventory inventory = player.getInventory();
            // item in hands
            ItemStack mainHand = inventory.getItemInMainHand();
            if (mainHand != null && isGlowStick(mainHand)) {
                damage(mainHand, player, inventory, true);
            }
            ItemStack offHand = inventory.getItemInOffHand();
            if (offHand != null && isGlowStick(offHand)) {
                damage(offHand, player, inventory, false);
            }
        }
    }

    private void damage(ItemStack glowStick, Player player, PlayerInventory inventory, boolean main) {
        Damageable damageable = (Damageable) glowStick.getItemMeta();
        int damage = damageable.getDamage() + 1;
        plugin.debug("damage: " + damage + ", maxDurability: " + glowStick.getType().getMaxDurability());
        if (damage >= glowStick.getType().getMaxDurability()) {
            if (main) {
                inventory.setItemInMainHand(null);
            } else {
                inventory.setItemInOffHand(null);
            }
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
        } else {
            damageable.setDamage(damage);
        }
        player.updateInventory();
    }

    private boolean isGlowStick(ItemStack glowStick) {
        return GlowStickMaterial.isStainedGlassPane(glowStick.getType()) && glowStick.hasItemMeta() && glowStick.getItemMeta().hasCustomModelData() && glowStick.containsEnchantment(Enchantment.LOYALTY);
    }
}
