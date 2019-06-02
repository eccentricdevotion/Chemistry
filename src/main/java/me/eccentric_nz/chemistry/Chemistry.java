package me.eccentric_nz.chemistry;

import me.eccentric_nz.chemistry.compound.CompoundCommand;
import me.eccentric_nz.chemistry.compound.CompoundGUIListener;
import me.eccentric_nz.chemistry.constructor.ConstructCommand;
import me.eccentric_nz.chemistry.constructor.ConstructorGUIListener;
import me.eccentric_nz.chemistry.creative.ChemistryCommand;
import me.eccentric_nz.chemistry.creative.CreativeGUIListener;
import me.eccentric_nz.chemistry.element.ElementGUIListener;
import me.eccentric_nz.chemistry.formula.FormulaCommand;
import me.eccentric_nz.chemistry.formula.FormulaViewerListener;
import me.eccentric_nz.chemistry.lab.LabCommand;
import me.eccentric_nz.chemistry.lab.LabGUIListener;
import me.eccentric_nz.chemistry.product.ProductCommand;
import me.eccentric_nz.chemistry.product.ProductGUIListener;
import me.eccentric_nz.chemistry.reducer.ReduceCommand;
import me.eccentric_nz.chemistry.reducer.ReducerGUIListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Chemistry extends JavaPlugin {

    public String pluginName;

    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here.
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile pdfFile = getDescription();
        pluginName = ChatColor.GOLD + "[" + pdfFile.getName() + "]" + ChatColor.RESET + " ";
        // add recipes
        new ChemistryRecipes(this).addRecipes();
        // register events
        pm.registerEvents(new ChemistryListener(this), this);
        pm.registerEvents(new CreativeGUIListener(this), this);
        pm.registerEvents(new ElementGUIListener(this), this);
        pm.registerEvents(new ConstructorGUIListener(this), this);
        pm.registerEvents(new CompoundGUIListener(this), this);
        pm.registerEvents(new ReducerGUIListener(this), this);
        pm.registerEvents(new ProductGUIListener(this), this);
        pm.registerEvents(new LabGUIListener(this), this);
        pm.registerEvents(new FormulaViewerListener(this), this);
        // register commands
        ChemistryCommand chemistryCommand = new ChemistryCommand(this);
        getCommand("chemistry").setExecutor(chemistryCommand);
        getCommand("chemistry").setTabCompleter(chemistryCommand);
        getCommand("construct").setExecutor(new ConstructCommand(this));
        getCommand("compound").setExecutor(new CompoundCommand(this));
        getCommand("reduce").setExecutor(new ReduceCommand(this));
        getCommand("product").setExecutor(new ProductCommand(this));
        getCommand("lab").setExecutor(new LabCommand(this));
        FormulaCommand formulaCommand = new FormulaCommand(this);
        getCommand("formula").setExecutor(formulaCommand);
        getCommand("formula").setTabCompleter(formulaCommand);
    }

    /**
     * Outputs a message to the console. Requires debug: true in config.yml
     *
     * @param o the Object to print to the console
     */
    public void debug(Object o) {
        getServer().getConsoleSender().sendMessage(pluginName + "Debug: " + o);
    }
}
