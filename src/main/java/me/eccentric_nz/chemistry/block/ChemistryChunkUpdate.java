package me.eccentric_nz.chemistry.block;

import net.minecraft.server.v1_14_R1.PacketPlayOutMapChunk;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_14_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ChemistryChunkUpdate {

    private final net.minecraft.server.v1_14_R1.Chunk chunk;

    /**
     * Creates a TARDISPacketMapChunk.
     *
     * @param world The chunk's world.
     * @param x     The chunk's X.
     * @param z     The chunk's Z.
     */
    public ChemistryChunkUpdate(World world, int x, int z) {
        this(world.getChunkAt(x, z));
    }

    /**
     * Creates a TARDISPacketMapChunk.
     *
     * @param chunk The chunk.
     */
    public ChemistryChunkUpdate(org.bukkit.Chunk chunk) {
        this.chunk = ((CraftChunk) chunk).getHandle();
    }

    /**
     * Refresh a chunk.
     *
     * @param chunk The chunk.
     */
    public static final void refreshChunk(org.bukkit.Chunk chunk) {
        refreshChunk(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    /**
     * Wrapper for <code>world.refreshChunk(...)</code>
     *
     * @param world The world.
     * @param x     The chunk's X.
     * @param z     The chunk's Z.
     */
    public static final void refreshChunk(World world, int x, int z) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        refreshChunk(world, x, z, players.toArray(new Player[players.size()]));
    }

    /**
     * Refresh a chunk for the selected players.
     *
     * @param world   The chunk's world.
     * @param x       The chunk's X.
     * @param z       The chunk's Z.
     * @param players The players.
     */
    public static final void refreshChunk(World world, int x, int z, Player... players) {
        ChemistryChunkUpdate packet = new ChemistryChunkUpdate(world.getChunkAt(x, z));
        for (Player player : players) {
            packet.send(player);
        }
        world.refreshChunk(x, z);
    }

    /**
     * Sends this packet to a player.
     * <br>You still need to refresh it manually with
     * <code>world.refreshChunk(...)</code>.
     *
     * @param player The player.
     */
    public final void send(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutMapChunk(chunk, 20));
    }
}
