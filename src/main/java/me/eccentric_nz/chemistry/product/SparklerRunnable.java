package me.eccentric_nz.chemistry.product;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class SparklerRunnable implements Runnable {

    private final Player player;
    private final BlockData colour;
    private final long startTime;
    //    private final NamespacedKey namespacedKey;
    private int taskId;

    public SparklerRunnable(Player player, BlockData colour, long startTime) {
        this.player = player;
        this.colour = colour;
        this.startTime = startTime;
//        namespacedKey = new NamespacedKey(this.plugin, "sparkler_time");
    }

    /**
     * Returns a location with a specified distance away from the right side of a location.
     *
     * @param location The origin location
     * @param distance The distance to the right
     * @return the location of the distance to the right
     */
    public static Location getRightSide(Location location, double distance) {
        double angle = Math.toRadians(location.getYaw());
        return location.clone().subtract(new Vector(Math.cos(angle), 0, Math.sin(angle)).normalize().multiply(distance));
    }

//    /**
//     * Gets a location with a specified distance away from the left side of a location.
//     *
//     * @param location The origin location
//     * @param distance The distance to the left
//     * @return the location of the distance to the left
//     */
//    public static Location getLeftSide(Location location, double distance) {
//        float angle = location.getYaw() / 60;
//        return location.clone().add(new Vector(Math.cos(angle), 0, Math.sin(angle)).normalize().multiply(distance));
//    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        PlayerInventory inventory = player.getInventory();
        // item in hands
        ItemStack mainHand = inventory.getItemInMainHand();
        if (isSparkler(mainHand)) {
            if (System.currentTimeMillis() < startTime + 30000) {
                Location rightHand = getRightSide(player.getEyeLocation(), 0.45).subtract(0, .2, 0); // right hand
                player.spawnParticle(Particle.BLOCK_DUST, rightHand, 5, colour);
            } else {
                inventory.setItemInMainHand(null);
                player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_DEATH, 1.0f, 1.0f);
                Bukkit.getScheduler().cancelTask(taskId);
                taskId = 0;
            }
        }
    }

    private boolean isSparkler(ItemStack sparkler) {
        return sparkler != null && SparklerMaterial.isCorrectMaterial(sparkler.getType()) && sparkler.hasItemMeta() && sparkler.getItemMeta().hasCustomModelData() && sparkler.containsEnchantment(Enchantment.LOYALTY);
    }
}
