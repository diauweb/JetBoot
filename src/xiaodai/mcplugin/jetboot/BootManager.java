package xiaodai.mcplugin.jetboot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

/**
 * Created in 2016 08.18
 *
 * @author Xiaodai
 */
public class BootManager {

    protected static HashMap<UUID,BukkitTask> managedPlayer = new HashMap<>();



    private static final ItemMeta item;
    static{
        item = new ItemStack(Material.GOLD_BOOTS).getItemMeta();
        item.setDisplayName("§b火箭靴 §a(300)");
        item.setLore(Arrays.asList
                ("§7火箭 I","","§7穿在脚上时:","§9 可向上喷射飞行"));
        item.spigot().setUnbreakable(true);
    }

    public static ItemStack getBoot(){
        ItemStack i = new ItemStack(Material.GOLD_BOOTS);
        i.setItemMeta(item);
        return i;
    }

    public static ItemStack enchants(ItemStack onHand){
        ItemStack i = onHand;
        ItemMeta  im = i.getItemMeta();
        im.setDisplayName("§b火箭靴 §a(300)");
        ArrayList<String> arrs = new ArrayList<>();
        arrs.add("§7火箭 I");
        if(!Objects.isNull(i.getItemMeta().getLore()))
            arrs.addAll(i.getItemMeta().getLore());
        arrs.addAll(Arrays.asList("","§7穿在脚上时:","§9 可向上喷射飞行"));
        im.setLore(arrs);

        i.setItemMeta(im);
        return i;
    }

    public static boolean isBoot(ItemStack i){
        try{
            return i.getItemMeta().getLore().contains("§7火箭 I");
        }catch(NullPointerException e){ return false; }
    }

    public static ItemStack setFuel(ItemStack i,short fuel){
        ItemStack is = i;
        ItemMeta im = is.getItemMeta();
        char color = 'a';
        if((300 - fuel) <= 60) color = '4';
        else if ((300 - fuel) <= 120) color = 'c';
        else if ((300 - fuel) <= 180) color = '6';
        else if ((300 - fuel) <= 240) color = 'e';
        im.setDisplayName(String.format("§b火箭靴 §%s(%d)",color,(300 - fuel)));
        is.setItemMeta(im);
        return is;
    }

}
