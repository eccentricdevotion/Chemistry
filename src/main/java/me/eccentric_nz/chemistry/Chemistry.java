package me.eccentric_nz.chemistry;

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
        pm.registerEvents(new ChemistryListener(this), this);
        pm.registerEvents(new ElementGUIListener(this), this);
        pm.registerEvents(new CompoundGUIListener(this), this);
        pm.registerEvents(new ReducerGUIListener(this), this);
        getCommand("chemistry").setExecutor(new ChemistryCommand(this));
        getCommand("compound").setExecutor(new CompoundCommand(this));
        getCommand("reduce").setExecutor(new ReduceCommand(this));
    }
}
