package me.eccentric_nz.chemistry.creative;

import me.eccentric_nz.chemistry.lab.Lab;
import me.eccentric_nz.chemistry.lab.LabBuilder;
import me.eccentric_nz.chemistry.product.Product;
import me.eccentric_nz.chemistry.product.ProductBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProductsCreativeInventory {

    private final ItemStack[] menu;

    public ProductsCreativeInventory() {
        menu = getItemStack();
    }

    private ItemStack[] getItemStack() {
        ItemStack[] stack = new ItemStack[54];
        int i = 0;
        for (Product entry : Product.values()) {
            if (i > 52) {
                break;
            }
            ItemStack is = ProductBuilder.getProduct(entry);
            stack[i] = is;
            i++;
        }
        for (Lab entry : Lab.values()) {
            if (i > 52) {
                break;
            }
            ItemStack is = LabBuilder.getLabProduct(entry);
            stack[i] = is;
            i++;
        }
        // close
        ItemStack close = new ItemStack(Material.BOWL, 1);
        ItemMeta close_im = close.getItemMeta();
        close_im.setDisplayName("Close");
        close_im.setCustomModelData(10000002);
        close.setItemMeta(close_im);
        stack[53] = close;
        return stack;
    }

    public ItemStack[] getMenu() {
        return menu;
    }
}
