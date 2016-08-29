package xiaodai.mcplugin.jetboot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class GiveBootCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender instanceof Player){
            ((Player) commandSender).getWorld()
                    .dropItem(((Player) commandSender).getLocation(),BootManager.getBoot());
            commandSender.sendMessage("§2Boots given!");
        }
        return true;
    }
}
