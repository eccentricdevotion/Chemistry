package me.eccentric_nz.chemistry.block;

import me.eccentric_nz.chemistry.Chemistry;
import me.eccentric_nz.chemistry.compound.CompoundInventory;
import me.eccentric_nz.chemistry.constructor.ConstructorInventory;
import me.eccentric_nz.chemistry.element.ElementInventory;
import me.eccentric_nz.chemistry.lab.LabInventory;
import me.eccentric_nz.chemistry.product.ProductInventory;
import me.eccentric_nz.chemistry.reducer.ReducerInventory;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChemistryBlockListener implements Listener {

    private final Chemistry plugin;
    private final HashMap<Material, String> blocks = new HashMap<>();
    //    private final List<String> names = Arrays.asList("Atomic elements", "Chemical compounds", "Material reducer", "Element constructor", "Lab table", "Product crafting");
    private final List<BlockFace> surrounding = Arrays.asList(BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.NORTH_WEST, BlockFace.SOUTH_EAST, BlockFace.SOUTH_WEST);

    public ChemistryBlockListener(Chemistry plugin) {
        this.plugin = plugin;
        blocks.put(Material.WHITE_GLAZED_TERRACOTTA, "Atomic elements");
        blocks.put(Material.ORANGE_GLAZED_TERRACOTTA, "Chemical compounds");
        blocks.put(Material.MAGENTA_GLAZED_TERRACOTTA, "Material reducer");
        blocks.put(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, "Element constructor");
        blocks.put(Material.YELLOW_GLAZED_TERRACOTTA, "Lab table");
        blocks.put(Material.LIME_GLAZED_TERRACOTTA, "Product crafting");
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onChemistryBlockInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Block block = event.getClickedBlock();
            if (!block.getBiome().equals(Biome.THE_VOID)) {
                return;
            }
            Material material = block.getType();
            if (!blocks.containsKey(material)) {
                return;
            }
            Player player = event.getPlayer();
            ItemStack[] menu;
            Inventory inventory;
            switch (material) {
                case WHITE_GLAZED_TERRACOTTA:
                    // elements
                    menu = new ElementInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 54, ChatColor.DARK_RED + "Atomic elements");
                    break;
                case ORANGE_GLAZED_TERRACOTTA:
                    // compound
                    menu = new CompoundInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Chemical compounds");
                    break;
                case MAGENTA_GLAZED_TERRACOTTA:
                    // reducer
                    menu = new ReducerInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Material reducer");
                    break;
                case LIGHT_BLUE_GLAZED_TERRACOTTA:
                    // constructor
                    menu = new ConstructorInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Element constructor");
                    break;
                case YELLOW_GLAZED_TERRACOTTA:
                    // lab
                    menu = new LabInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Lab table");
                    break;
                default:
                    // product
                    menu = new ProductInventory().getMenu();
                    inventory = plugin.getServer().createInventory(player, 27, ChatColor.DARK_RED + "Product crafting");
                    break;
            }
            inventory.setContents(menu);
            player.openInventory(inventory);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onChemistryBlockPlace(BlockPlaceEvent event) {
        if (!blocks.containsKey(event.getBlock().getType())) {
            return;
        }
        if (!event.getItemInHand().hasItemMeta()) {
            return;
        }
        if (!event.getItemInHand().getItemMeta().hasDisplayName()) {
            return;
        }
        if (!blocks.containsValue(event.getItemInHand().getItemMeta().getDisplayName())) {
            return;
        }
        Location l = event.getBlock().getLocation();
        // set biome
        l.getWorld().setBiome(l.getBlockX(), l.getBlockZ(), Biome.THE_VOID);
        ChemistryChunkUpdate.refreshChunk(l.getChunk());
    }

    @EventHandler(ignoreCancelled = true)
    public void onChemistryBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (!blocks.containsKey(event.getBlock().getType())) {
            return;
        }
        ItemStack is = new ItemStack(block.getType(), 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(blocks.get(block.getType()));
        is.setItemMeta(im);
        block.setBlockData(Material.AIR.createBlockData());
        block.getWorld().dropItemNaturally(event.getPlayer().getLocation(), is);
        // reset biome
        Biome b = Biome.THE_VOID;
        if (block.getBiome().equals(Biome.THE_VOID)) {
            for (BlockFace f : surrounding) {
                b = block.getRelative(f).getBiome();
                if (!b.equals(Biome.THE_VOID)) {
                    break;
                }
            }
            Location l = block.getLocation();
            l.getWorld().setBiome(l.getBlockX(), l.getBlockZ(), b);
            Chunk c = l.getChunk();
            ChemistryChunkUpdate.refreshChunk(c);
        }
    }
}
