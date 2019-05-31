package me.eccentric_nz.chemistry;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ReduceCommand implements CommandExecutor {

    private final Chemistry plugin;

    public ReduceCommand(Chemistry plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("reduce")) {
            Player player = null;
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            if (player == null) {
                sender.sendMessage(plugin.pluginName + "Command can only be used by a player!");
                return true;
            }
            // do stuff
            ItemStack[] menu = new ReducerInventory().getMenu();
            Inventory reductions = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Material reducer");
            reductions.setContents(menu);
            player.openInventory(reductions);
            return true;
        }
        return false;
    }
}
