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
        // check recipe
        ItemStack scroll_down = new ItemStack(Material.BOWL, 1);
        ItemMeta dim = scroll_down.getItemMeta();
        dim.setDisplayName("Craft");
        scroll_down.setItemMeta(dim);
        stack[17] = scroll_down;
        // close
        ItemStack close = new ItemStack(Material.BOWL, 1);
        ItemMeta close_im = close.getItemMeta();
        close_im.setDisplayName("Close");
        close.setItemMeta(close_im);
        stack[26] = close;
        return stack;
    }

    public ItemStack[] getMenu() {
        return menu;
    }
}
