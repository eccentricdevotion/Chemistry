package me.eccentric_nz.chemistry.creative;

import me.eccentric_nz.chemistry.Chemistry;
import me.eccentric_nz.chemistry.element.ElementInventory;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

public class ChemistryCommand implements CommandExecutor {

    private final Chemistry plugin;

    public ChemistryCommand(Chemistry plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chemistry")) {
            if (args.length < 1) {
                return false;
            }
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
            Creative creative;
            try {
                creative = Creative.valueOf(args[0].toLowerCase(Locale.ENGLISH));
            } catch (IllegalArgumentException e) {
                return false;
            }
            // do stuff
            switch (creative) {
                case elements:
                    ItemStack[] emenu = new ElementInventory().getMenu();
                    Inventory elements = plugin.getServer().createInventory(player, 54, ChatColor.DARK_RED + "Atomic elements");
                    elements.setContents(emenu);
                    player.openInventory(elements);
                    return true;
                case compounds:
                    ItemStack[] cmenu = new CompoundsCreativeInventory().getMenu();
                    Inventory compounds = plugin.getServer().createInventory(player, 54, ChatColor.DARK_RED + "Molecular compounds");
                    compounds.setContents(cmenu);
                    player.openInventory(compounds);
                    return true;
                default: // lab & products
                    ItemStack[] lmenu = new ProductsCreativeInventory().getMenu();
                    Inventory lab = plugin.getServer().createInventory(player, 54, ChatColor.DARK_RED + "Products");
                    lab.setContents(lmenu);
                    player.openInventory(lab);
                    return true;
            }
        }
        return false;
    }
}
