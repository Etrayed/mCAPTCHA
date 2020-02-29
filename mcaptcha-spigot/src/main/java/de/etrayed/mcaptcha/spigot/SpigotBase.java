package de.etrayed.mcaptcha.spigot;

import de.etrayed.mcaptcha.AbstractBase;
import de.etrayed.mcaptcha.config.PluginConfiguration;
import de.etrayed.mcaptcha.player.CaptchaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.jar.JarFile;

public final class SpigotBase extends AbstractBase {

    private final PluginConfiguration configuration;

    public SpigotBase(Plugin plugin, File jarFile) throws IOException {
        super(plugin);

        this.configuration = loadConfiguration(new JarFile(jarFile), Paths.get(plugin.getDataFolder() + "config.yml"));
    }

    public PluginConfiguration configuration() {
        return configuration;
    }

    @Override
    public UUID resolveUniqueId(Object identifier) {
        if(identifier instanceof UUID) {
            return (UUID) identifier;
        } else if(identifier instanceof Player) {
            return ((Player) identifier).getUniqueId();
        } else if(identifier instanceof String) {
            Player player = Bukkit.getPlayer(String.valueOf(identifier));

            return player == null ? null : player.getUniqueId();
        }

        return null;
    }

    @Override
    public CaptchaPlayer createPlayer(UUID uniqueId) {
        return null;
    }
}
