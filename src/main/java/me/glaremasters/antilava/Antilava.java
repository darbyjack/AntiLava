package me.glaremasters.antilava;

import me.glaremasters.antilava.commands.CMDReload;
import me.glaremasters.antilava.events.Lava;
import org.bukkit.plugin.java.JavaPlugin;

public final class Antilava extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Lava(this), this);
        this.getCommand("alreload").setExecutor(new CMDReload(this));
    }

    @Override
    public void onDisable() {
    }
}
