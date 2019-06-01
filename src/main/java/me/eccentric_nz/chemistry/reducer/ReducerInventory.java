package me.eccentric_nz.chemistry.reducer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReducerInventory {

    private final ItemStack[] menu;

    public ReducerInventory() {
        menu = getItemStack();
    }

    private ItemStack[] getItemStack() {
        ItemStack[] stack = new ItemStack[27];
        // check formula
        ItemStack scroll_down = new ItemStack(Material.BOWL, 1);
        ItemMeta dim = scroll_down.getItemMeta();
        dim.setDisplayName("Reduce");
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
