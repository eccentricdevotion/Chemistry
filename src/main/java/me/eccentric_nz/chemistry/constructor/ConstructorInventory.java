package me.eccentric_nz.chemistry.constructor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConstructorInventory {

    private final ItemStack[] menu;

    public ConstructorInventory() {
        menu = getItemStack();
    }

    private ItemStack[] getItemStack() {
        ItemStack[] stack = new ItemStack[27];
        // proton count
        ItemStack p_zero = new ItemStack(Material.BOWL, 1);
        ItemMeta pzim = p_zero.getItemMeta();
        pzim.setDisplayName("0");
        pzim.setCustomModelData(10000010);
        p_zero.setItemMeta(pzim);
        stack[2] = p_zero;
        // protons
        ItemStack protons = new ItemStack(Material.BOWL, 1);
        ItemMeta pim = protons.getItemMeta();
        pim.setDisplayName("Protons");
        pzim.setCustomModelData(10000006);
        protons.setItemMeta(pim);
        stack[3] = protons;
        // proton down
        ItemStack proton_down = new ItemStack(Material.ARROW, 1);
        ItemMeta pdim = proton_down.getItemMeta();
        pdim.setDisplayName("-");
        pdim.setCustomModelData(10000004);
        proton_down.setItemMeta(pdim);
        stack[4] = proton_down;
        // proton up
        ItemStack proton_up = new ItemStack(Material.ARROW, 1);
        ItemMeta puim = proton_up.getItemMeta();
        puim.setDisplayName("+");
        puim.setCustomModelData(10000003);
        proton_up.setItemMeta(puim);
        stack[5] = proton_up;
        // neutron count
        ItemStack n_zero = new ItemStack(Material.BOWL, 1);
        ItemMeta nzim = n_zero.getItemMeta();
        nzim.setDisplayName("0");
        nzim.setCustomModelData(10000010);
        n_zero.setItemMeta(nzim);
        stack[11] = n_zero;
        // neutrons
        ItemStack neutrons = new ItemStack(Material.BOWL, 1);
        ItemMeta nim = neutrons.getItemMeta();
        nim.setDisplayName("Neutrons");
        nim.setCustomModelData(10000005);
        neutrons.setItemMeta(nim);
        stack[12] = neutrons;
        // neutron down
        ItemStack neutron_down = new ItemStack(Material.ARROW, 1);
        ItemMeta ndim = neutron_down.getItemMeta();
        ndim.setDisplayName("-");
        ndim.setCustomModelData(10000004);
        neutron_down.setItemMeta(ndim);
        stack[13] = neutron_down;
        // neutron up
        ItemStack neutron_up = new ItemStack(Material.ARROW, 1);
        ItemMeta nuim = neutron_up.getItemMeta();
        nuim.setDisplayName("+");
        nuim.setCustomModelData(10000003);
        neutron_up.setItemMeta(nuim);
        stack[14] = neutron_up;
        // electron count
        ItemStack e_zero = new ItemStack(Material.BOWL, 1);
        ItemMeta ezim = e_zero.getItemMeta();
        ezim.setDisplayName("0");
        ezim.setCustomModelData(10000010);
        e_zero.setItemMeta(ezim);
        stack[20] = e_zero;
        // electrons
        ItemStack electrons = new ItemStack(Material.BOWL, 1);
        ItemMeta eim = electrons.getItemMeta();
        eim.setDisplayName("Electrons");
        eim.setCustomModelData(10000004);
        electrons.setItemMeta(eim);
        stack[21] = electrons;
        // electron down
        ItemStack electron_down = new ItemStack(Material.ARROW, 1);
        ItemMeta edim = electron_down.getItemMeta();
        edim.setDisplayName("-");
        edim.setCustomModelData(10000004);
        electron_down.setItemMeta(edim);
        stack[22] = electron_down;
        // electron up
        ItemStack electron_up = new ItemStack(Material.ARROW, 1);
        ItemMeta euim = electron_up.getItemMeta();
        euim.setDisplayName("+");
        euim.setCustomModelData(10000003);
        electron_up.setItemMeta(euim);
        stack[23] = electron_up;
        return stack;
    }

    public ItemStack[] getMenu() {
        return menu;
    }
}
