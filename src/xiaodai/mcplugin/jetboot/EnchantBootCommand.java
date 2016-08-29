package xiaodai.mcplugin.jetboot;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

/**
 * Created in 2016 08.20
 *
 * @author Xiaodai
 */
public class EnchantBootCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender instanceof Player){
            if(((Player) commandSender).getInventory().getItemInMainHand().getType() == Material.AIR){
                commandSender.sendMessage("§4There's Nothing on hand!");
            }else if(BootManager.isBoot(((Player) commandSender).getInventory().getItemInMainHand())){
                commandSender.sendMessage("§2This is already a JetBoot!");
            }else{
                BootManager.enchants(((Player) commandSender).getInventory().getItemInMainHand());
                commandSender.sendMessage("§2Enchanted item on hand!");
            }
        }
        return true;
    }
}
