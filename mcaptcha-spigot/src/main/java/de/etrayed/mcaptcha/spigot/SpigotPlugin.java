package de.etrayed.mcaptcha.spigot;

import de.etrayed.mcaptcha.MCaptcha;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.lang.reflect.Field;

public class SpigotPlugin extends JavaPlugin {

    private SpigotBase spigotBase;

    @Override
    public void onEnable() {
        try {
            this.spigotBase = new SpigotBase(this, this.getFile());

            this.getServer().getServicesManager().register(MCaptcha.class, spigotBase, this, ServicePriority.Highest);

            if(spigotBase.configuration().isCommandEnabled()) {
                registerCommand();
            }

            if(spigotBase.configuration().isJoinCheckEnabled()) {
                this.getServer().getPluginManager().registerEvents(null, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerCommand() {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            commandMapField.setAccessible(true);

            ((CommandMap) commandMapField.get(Bukkit.getServer())).register("mcaptcha", null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new AssertionError("Could not access commandMap", e);
        }
    }
}
