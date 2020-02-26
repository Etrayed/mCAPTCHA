package de.etrayed.mcaptcha.spigot;

import de.etrayed.mcaptcha.config.PluginConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotPlugin extends JavaPlugin {

    private PluginConfiguration configuration;

    @Override
    public void onEnable() {
        this.configuration = new PluginConfiguration();
    }
}
