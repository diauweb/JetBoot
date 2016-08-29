package xiaodai.mcplugin.jetboot;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class BootListener implements Listener {

    private Main plugin;

    public BootListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onFly(PlayerMoveEvent e){
        if((!Objects.isNull(e.getPlayer().getInventory().getBoots())) &&
                BootManager.isBoot(e.getPlayer().getInventory().getBoots())){
            if(e.getPlayer().isFlying()){
                short fuel = e.getPlayer().getInventory().getBoots().getDurability();
                e.getPlayer().getInventory().setBoots(
                        BootManager.setFuel(e.getPlayer().getInventory().getBoots(),fuel));
                if(fuel > 300){
                    e.getPlayer().setFlying(false);
                    e.getPlayer().setAllowFlight(false);
                    return;
                }

                this.doDeactivating(e.getPlayer());
                //e.getPlayer().sendMessage("Durability = " + fuel);

                if(e.getFrom().distance(e.getTo()) > 0.38) this.doReactivating(e.getPlayer());

                 e.getPlayer().getInventory().getBoots().setDurability((short)(fuel + 1));

            }else e.getPlayer().setAllowFlight(true); //If in boots & not flying
        }
    }

    private void doDeactivating(Player p){
        BootManager.managedPlayer.put(p.getUniqueId(),
                Bukkit.getScheduler().runTaskLater(this.plugin,() -> {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.getWorld().spigot().playEffect(p.getLocation(),Effect.EXPLOSION_LARGE,0,0,0.1F,0.1F,0.1F,2F,1,1);
                },3L));
    }

    private void doReactivating(Player e){
        if(BootManager.managedPlayer.containsKey(e.getUniqueId())){
            BootManager.managedPlayer.remove(e.getUniqueId()).cancel();
            e.getWorld().spigot().playEffect(e.getLocation(),Effect.MOBSPAWNER_FLAMES,0,0,0.2F,0.2F,0.2F,1F,150,1);
        }
    }

}
