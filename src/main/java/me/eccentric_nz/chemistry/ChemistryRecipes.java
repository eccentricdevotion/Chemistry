package me.eccentric_nz.chemistry;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChemistryRecipes {

    private final Chemistry plugin;
    private final List<RecipeData> recipes = new ArrayList<>();

    public ChemistryRecipes(Chemistry plugin) {
        this.plugin = plugin;
        recipes.add(new RecipeData("Atomic elements", "creative_block", Material.WHITE_GLAZED_TERRACOTTA, Material.DIAMOND));
        recipes.add(new RecipeData("Chemical compounds", "compound_block", Material.ORANGE_GLAZED_TERRACOTTA, Material.REDSTONE));
        recipes.add(new RecipeData("Material reducer", "reducer_block", Material.MAGENTA_GLAZED_TERRACOTTA, Material.GOLD_NUGGET));
        recipes.add(new RecipeData("Lab table", "lab_block", Material.YELLOW_GLAZED_TERRACOTTA, Material.COAL));
        recipes.add(new RecipeData("Product crafting", "crafting_block", Material.LIME_GLAZED_TERRACOTTA, Material.IRON_NUGGET));
    }

    public void addRecipes() {
        for (RecipeData data : recipes) {
            ItemStack is = new ItemStack(data.getItemMaterial(), 1);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(data.getDisplayName());
            NamespacedKey creative_key = new NamespacedKey(plugin, data.getNameSpacedKey());
            ShapedRecipe recipe = new ShapedRecipe(creative_key, is);
            recipe.shape("AAA", "ACA", "AAA");
            recipe.setIngredient('A', data.getCraftMaterial());
            recipe.setIngredient('C', Material.CRAFTING_TABLE);
            plugin.getServer().addRecipe(recipe);
        }
    }
}
