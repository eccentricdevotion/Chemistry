package me.eccentric_nz.chemistry.product;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProductInventory {

    private final ItemStack[] menu;

    public ProductInventory() {
        menu = getItemStack();
    }

    private ItemStack[] getItemStack() {
        ItemStack[] stack = new ItemStack[27];
        // craft recipe
        ItemStack craft = new ItemStack(Material.BOWL, 1);
        ItemMeta craft_im = craft.getItemMeta();
        craft_im.setDisplayName("Craft");
        craft.setItemMeta(craft_im);
        craft_im.setCustomModelData(10000003);
        stack[17] = craft;
        // close
        ItemStack close = new ItemStack(Material.BOWL, 1);
        ItemMeta close_im = close.getItemMeta();
        close_im.setDisplayName("Close");
        close_im.setCustomModelData(10000002);
        close.setItemMeta(close_im);
        stack[26] = close;
        return stack;
    }

    public ItemStack[] getMenu() {
        return menu;
    }
}
