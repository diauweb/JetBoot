package xiaodai.mcplugin.jetboot;

import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
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

        Bukkit.getPluginManager().registerEvents(new BootListener(this),this);
        Bukkit.getPluginCommand("giveboot").setExecutor(new GiveBootCommand());
        Bukkit.getPluginCommand("setjetboot").setExecutor(new EnchantBootCommand());


    }



}
