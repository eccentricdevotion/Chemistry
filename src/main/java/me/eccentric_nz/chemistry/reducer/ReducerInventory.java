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
        ItemStack check = new ItemStack(Material.BOWL, 1);
        ItemMeta check_im = check.getItemMeta();
        check_im.setDisplayName("Reduce");
        check_im.setCustomModelData(10000007);
        check.setItemMeta(check_im);
        stack[17] = check;
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
