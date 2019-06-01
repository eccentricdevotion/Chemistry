package me.eccentric_nz.chemistry.product;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProductBuilder {

    public static ItemStack getProduct(Product product) {
        ItemStack is = new ItemStack(product.getItemMaterial(), 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(product.toString().replace("_", " "));
        is.setItemMeta(im);
        return is;
    }
}
