package me.eccentric_nz.chemistry;

import org.bukkit.Material;

public class RecipeData {

    private final String displayName;
    private final String nameSpacedKey;
    private final Material itemMaterial;
    private final Material craftMaterial;

    public RecipeData(String displayName, String namespacedKey, Material itemMaterial, Material craftMaterial) {
        this.displayName = displayName;
        nameSpacedKey = namespacedKey;
        this.itemMaterial = itemMaterial;
        this.craftMaterial = craftMaterial;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getNameSpacedKey() {
        return nameSpacedKey;
    }

    public Material getItemMaterial() {
        return itemMaterial;
    }

    public Material getCraftMaterial() {
        return craftMaterial;
    }
}
