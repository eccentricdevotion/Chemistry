package me.eccentric_nz.chemistry.product;

import me.eccentric_nz.chemistry.Chemistry;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SparklerRunnable implements Runnable {

    private final Chemistry plugin;
    private final Player player;
    private final BlockData colour;
    private final long startTime;
    private int taskId;

    public SparklerRunnable(Chemistry plugin, Player player, BlockData colour, long startTime) {
        this.plugin = plugin;
        this.player = player;
        this.colour = colour;
        this.startTime = startTime;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        PlayerInventory inventory = player.getInventory();
        // item in hands
        ItemStack mainHand = inventory.getItemInMainHand();
        if (isSparkler(mainHand)) {
            if (System.currentTimeMillis() < startTime + 6000) {
                Location rightHand = getHandLocation();
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

    private Location getHandLocation() {
        double degrees = toThreeSixty(Location.normalizeYaw(player.getLocation().getYaw()));
        double yaw = Math.toRadians(degrees);
        // not sure about 0.4, i think you'll have to test it out and find the best.
        double handRadius = 0.75d;
        double realXOffset = Math.cos(yaw) * handRadius;
        double realZOffset = Math.sin(yaw) * handRadius;
        // not sure about 1.2, i think you'll have to test it out and find the best.
        double staticYOffset = 1.2d;
        return player.getLocation().clone().add(realXOffset, staticYOffset, realZOffset);
    }

    private double toThreeSixty(double angle) {
        double threeSixty = (angle < 0 && angle >= -180) ? angle + 360 : angle;
        return (threeSixty + 180) % 360;
    }
}
