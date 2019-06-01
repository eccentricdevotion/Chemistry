package me.eccentric_nz.chemistry.lab;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class LabGUIListener implements Listener {

    private final Chemistry plugin;
    private final List<Integer> slots = Arrays.asList(18, 19, 20, 21, 22, 23);

    public LabGUIListener(Chemistry plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onLabMenuClick(InventoryClickEvent event) {
        InventoryView view = event.getView();
        String name = view.getTitle();
        if (name.equals(ChatColor.DARK_RED + "Lab table")) {
            Player player = (Player) event.getWhoClicked();
            int slot = event.getRawSlot();
            if (slot >= 0 && slot < 27) {
                switch (slot) {
                    case 0:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        // do nothing
                        break;
                    case 17:
                        // check product
                        event.setCancelled(true);
                        check(event.getClickedInventory(), player);
                        break;
                    case 26:
                        // close
                        event.setCancelled(true);
                        close(player);
                        break;
                    default:
                        event.setCancelled(true);
                        break;
                }
            } else {
                ClickType click = event.getClick();
                if (click.equals(ClickType.SHIFT_RIGHT) || click.equals(ClickType.SHIFT_LEFT) || click.equals(ClickType.DOUBLE_CLICK)) {
                    event.setCancelled(true);
                }
            }
        }
    }

    private void check(Inventory inventory, Player player) {
        StringBuilder builder = new StringBuilder();
        for (int slot : slots) {
            ItemStack is = inventory.getItem(slot);
            if (is != null) {
                Material material = is.getType();
                if ((material.equals(Material.GLASS_BOTTLE) || material.equals(Material.FEATHER)) && is.hasItemMeta()) {
                    ItemMeta im = is.getItemMeta();
                    if (im.hasDisplayName()) {
                        builder.append(im.getDisplayName()).append(",");
                    }
                } else {
                    builder.append(is.getType().toString()).append(",");
                }
            } else {
                builder.append("-").append(",");
            }
        }
        String recipe = builder.toString().substring(0, builder.length() - 1);
        for (Lab lab : Lab.values()) {
            if (lab.getRecipe().equals(recipe)) {
                craft(lab, inventory, player);
                return;
            }
        }
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
    }

    private void craft(Lab product, Inventory inventory, Player player) {
        ItemStack crafted = new ItemStack(product.getItemMaterial(), 1);
        ItemMeta cm = crafted.getItemMeta();
        cm.setDisplayName(product.toString().replace("_", " "));
        crafted.setItemMeta(cm);
        // set slot 14 to the crafted product
        inventory.setItem(14, crafted);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        // remove the crafting item stacks
        for (int i : slots) {
            inventory.setItem(i, null);
        }
    }

    /**
     * Closes the inventory.
     *
     * @param p the player using the GUI
     */
    private void close(Player p) {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, p::closeInventory, 1L);
    }
}
