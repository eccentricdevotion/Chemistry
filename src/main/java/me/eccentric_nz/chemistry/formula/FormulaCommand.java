package me.eccentric_nz.chemistry.formula;

import com.google.common.collect.ImmutableList;
import me.eccentric_nz.chemistry.Chemistry;
import me.eccentric_nz.chemistry.compound.Compound;
import me.eccentric_nz.chemistry.lab.Lab;
import me.eccentric_nz.chemistry.product.Product;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FormulaCommand implements CommandExecutor, TabCompleter {

    private final Chemistry plugin;
    private final List<String> ROOT_SUBS = new ArrayList<>();

    public FormulaCommand(Chemistry plugin) {
        this.plugin = plugin;
        for (Compound compound : Compound.values()) {
            ROOT_SUBS.add(compound.toString());
        }
        for (Product product : Product.values()) {
            ROOT_SUBS.add(product.toString());
        }
        for (Lab lab : Lab.values()) {
            ROOT_SUBS.add(lab.toString());
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("formula")) {
            Player player = null;
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            if (player == null) {
                sender.sendMessage(plugin.pluginName + "Command can only be used by a player!");
                return true;
            }
            if (args.length < 1) {
                sender.sendMessage(plugin.pluginName + "You need to specify the compound or product you want the formula for! Try using tab complete...");
                return false;
            }
            // do stuff
            try {
                Compound compound = Compound.valueOf(args[0]);
                new FormulaViewer(plugin, player).getCompoundFormula(compound);
                return true;
            } catch (IllegalArgumentException ce) {
                try {
                    Product product = Product.valueOf(args[0]);
                    new FormulaViewer(plugin, player).getProductFormula(product);
                    return true;
                } catch (IllegalArgumentException pe) {
                    try {
                        Lab lab = Lab.valueOf(args[0]);
                        new FormulaViewer(plugin, player).getLabFormula(lab);
                        return true;
                    } catch (IllegalArgumentException le) {
                        sender.sendMessage(plugin.pluginName + "Could not find a formula for '" + args[0] + "' make sure you typed it correctly.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        // Remember that we can return null to default to online player name matching
        if (args.length <= 1) {
            return partial(args[0], ROOT_SUBS);
        }
        return ImmutableList.of();
    }

    protected List<String> partial(String token, Collection<String> from) {
        return StringUtil.copyPartialMatches(token, from, new ArrayList<>(from.size()));
    }
}
