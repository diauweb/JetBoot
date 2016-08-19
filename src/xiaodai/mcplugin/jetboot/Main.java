package xiaodai.mcplugin.jetboot;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class Main extends JavaPlugin implements CommandExecutor{

    private ProtocolManager pm;

    @Override
    public void onEnable(){
        this.getLogger().info("JetBoot has been enabled! (laughs");
        this.getLogger().info("***************************");
        this.getLogger().info(" JetBoot Plugin by Xiaodai ");
        this.getLogger().info("***************************");

        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this),this);
        Bukkit.getPluginCommand("giveboot").setExecutor(new BootCommand());


    }



}
