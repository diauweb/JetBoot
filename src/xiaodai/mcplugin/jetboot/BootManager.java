package xiaodai.mcplugin.jetboot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class BootManager {

    protected ArrayList<UUID> usingBoot;



    private static final ItemMeta item;
    static{
        item = new ItemStack(Material.GOLD_BOOTS).getItemMeta();
        item.setDisplayName("§b火箭靴");
        item.setLore(Arrays.asList
                ("§7火箭 I","","§7穿在脚上时:","§9 可向上喷射飞行"));
        item.spigot().setUnbreakable(true);
    }

    public static ItemStack getBoot(){
        ItemStack i = new ItemStack(Material.GOLD_BOOTS);
        i.setItemMeta(item);

        return i;
    }

    public static boolean isBoot(ItemStack i){
        return i.getItemMeta().equals(item);
    }
}
