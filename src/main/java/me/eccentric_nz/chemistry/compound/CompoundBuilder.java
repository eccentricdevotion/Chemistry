package me.eccentric_nz.chemistry.compound;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CompoundBuilder {

    public static ItemStack getCompound(Compound compound) {
        ItemStack is = new ItemStack(Material.GLASS_BOTTLE, 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(compound.toString().replace("_", " "));
        im.setLore(Arrays.asList(compound.getSymbol()));
        is.setItemMeta(im);
        return is;
    }
}
