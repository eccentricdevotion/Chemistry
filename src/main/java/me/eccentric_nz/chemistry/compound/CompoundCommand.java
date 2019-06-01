package me.eccentric_nz.chemistry.compound;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CompoundCommand implements CommandExecutor {

    private final Chemistry plugin;

    public CompoundCommand(Chemistry plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("compound")) {
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
            ItemStack[] menu = new CompoundInventory().getMenu();
            Inventory compounds = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Chemical compounds");
            compounds.setContents(menu);
            player.openInventory(compounds);
            return true;
        }
        return false;
    }
}
