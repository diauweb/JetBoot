package xiaodai.mcplugin.jetboot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class PlayerMoveListener implements Listener {

    private Main plugin;

    public PlayerMoveListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onFly(PlayerMoveEvent e){
        if(BootManager.isBoot(e.getPlayer().getInventory().getBoots())){
            e.getPlayer().setFlying(true);
        }
        if(!e.getPlayer().isOnGround()){
            e.getPlayer().setFlying(true);
        }
    }
}
