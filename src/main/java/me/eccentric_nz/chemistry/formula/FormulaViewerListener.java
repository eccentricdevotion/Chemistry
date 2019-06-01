package me.eccentric_nz.chemistry.formula;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FormulaViewerListener implements Listener {

    private final List<UUID> viewers = new ArrayList<>();
    private final Chemistry plugin;

    public FormulaViewerListener(Chemistry plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onFormulaViewerOpen(InventoryOpenEvent event) {
        if (event.getView().getTitle().endsWith("Formula")) {
            Player player = (Player) event.getPlayer();
            UUID uuid = player.getUniqueId();
            viewers.add(uuid);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onFormulaViewerClick(InventoryClickEvent event) {
        Inventory top = event.getView().getTopInventory();
        InventoryType type = top.getType();
        if (type == InventoryType.CHEST) {
            Player player = (Player) event.getWhoClicked();
            if (viewers.contains(player.getUniqueId())) {
                event.setCancelled(true);
                if (event.getRawSlot() == 26) {
                    // close
                    close(player);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onFormulaViewerClose(InventoryCloseEvent event) {
        Inventory top = event.getView().getTopInventory();
        InventoryType type = top.getType();
        if (type == InventoryType.CHEST) {
            Player p = (Player) event.getPlayer();
            UUID uuid = p.getUniqueId();
            if (viewers.contains(uuid)) {
                viewers.remove(uuid);
                event.getView().getTopInventory().clear();
                p.updateInventory();
            }
        }
    }

    public void close(Player p) {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, p::closeInventory, 1L);
    }
}
