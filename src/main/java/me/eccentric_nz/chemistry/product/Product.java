package me.eccentric_nz.chemistry.product;

import org.bukkit.Material;

public enum Product {

    Blue_Torch("-,Ceruim Chloride,-|-,Torch,-|-,-,-", Material.TORCH),
    Red_Torch("-,Mercuric Chloride,-|-,Torch,-|-,-,-", Material.TORCH),
    Purple_Torch("-,Potassium Chloride,-|-,Torch,-|-,-,-", Material.TORCH),
    Green_Torch("-,Tungsten Chloride,-|-,Torch,-|-,-,-", Material.TORCH),
    White_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,WHITE_Dye,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Orange_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,ORANGE_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Magenta_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,MAGENTA_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Light_Blue_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,LIGHT_BLUE_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Yellow_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,YELLOW_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Lime_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,LIME_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Pink_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,PINK_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Gray_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,GRAY_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Cyan_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,CYAN_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Purple_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,PURPLE_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Blue_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,BLUE_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Brown_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,BROWN_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Green_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,GREEN_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    Red_Glow_Stick("Polyethylene,Luminol,Polyethylene|Polyethylene,RED_DYE,Polyethylene|Polyethylene,Hydrogen Peroxide,Polyethylene", Material.STICK),
    White_Balloon("Latex,WHITE_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Orange_Balloon("Latex,ORANGE_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Light_Blue_Balloon("Latex,LIGHT_BLUE_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Yellow_Balloon("Latex,YELLOW_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Lime_Balloon("Latex,LIME_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Pink_Balloon("Latex,PINK_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Gray_Balloon("Latex,GRAY_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Light_Gray_Balloon("Latex,LIGHT_GRAY_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Cyan_Balloon("Latex,CYAN_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Purple_Balloon("Latex,PURPLE_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Blue_Balloon("Latex,BLUE_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Brown_Balloon("Latex,BROWN_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Green_Balloon("Latex,GREEN_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Red_Balloon("Latex,RED_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Black_Balloon("Latex,BLACK_DYE,Latex|Latex,Helium,Latex|Latex,STRING,Latex", Material.CORNFLOWER),
    Orange_Sparkler("-,Calcium Chloride,-|-,Magnesium,-|-,STICK,-", Material.END_ROD),
    Blue_Sparkler("-,Cerium Chloride,-|-,Magnesium,-|-,STICK,-", Material.END_ROD),
    Green_Sparkler("-,Tungsten Chloride,-|-,Magnesium,-|-,STICK,-", Material.END_ROD),
    Purple_Sparkler("-,Potassium Chloride,-|-,Magnesium,-|-,STICK,-", Material.END_ROD),
    Red_Sparkler("-,Mercuric Chloride,-|-,Magnesium,-|-,STICK,-", Material.END_ROD);

    private final String recipe;
    private final Material itemMaterial;

    Product(String recipe, Material itemMaterial) {
        this.recipe = recipe;
        this.itemMaterial = itemMaterial;
    }

    public String getRecipe() {
        return recipe;
    }

    public Material getItemMaterial() {
        return itemMaterial;
    }
}
