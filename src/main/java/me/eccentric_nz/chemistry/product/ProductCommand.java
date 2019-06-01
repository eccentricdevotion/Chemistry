package me.eccentric_nz.chemistry.product;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ProductCommand implements CommandExecutor {

    private final Chemistry plugin;

    public ProductCommand(Chemistry plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("product")) {
            Player player = null;
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            if (player == null) {
                sender.sendMessage(plugin.pluginName + "Command can only be used by a player!");
                return true;
            }
            if (!player.hasPermission("chemistry.command")) {
                sender.sendMessage(plugin.pluginName + "You don't have permission to open Chemistry GUIs by command!");
                return true;
            }
            // do stuff
            ItemStack[] menu = new ProductInventory().getMenu();
            Inventory products = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Product crafting");
            products.setContents(menu);
            player.openInventory(products);
            return true;
        }
        return false;
    }
}
