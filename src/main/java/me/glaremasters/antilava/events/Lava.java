package me.glaremasters.antilava.events;

import me.glaremasters.antilava.Antilava;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by GlareMasters
 * Date: 8/7/2018
 * Time: 12:39 PM
 */
public class Lava implements Listener {

    private Antilava antilava;

    public Lava(Antilava antilava) {
        this.antilava = antilava;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        FileConfiguration c = antilava.getConfig();
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String world = player.getWorld().getName();
            if (event.getCause() == EntityDamageEvent.DamageCause.LAVA || event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                if (c.getStringList("disabled-worlds").contains(world)) event.setCancelled(true);
            }
        }
    }

}
