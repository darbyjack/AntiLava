package me.glaremasters.antilava.events;

import me.glaremasters.antilava.Antilava;
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
        if (event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
            if (antilava.getConfig().getStringList("disabled-worlds").contains(event.getEntity().getWorld().toString())) {
                event.setCancelled(true);
            }
        }
    }

}
