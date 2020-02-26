package de.etrayed.mcaptcha;

import de.etrayed.mcaptcha.config.ConfigObject;
import de.etrayed.mcaptcha.config.PluginConfiguration;
import de.etrayed.mcaptcha.player.DelegatePlayerFactory;
import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.player.PlayerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.jar.JarFile;

public abstract class AbstractBase implements MCaptcha {

    private static final Yaml YAML = new Yaml();

    private final Object plugin;

    private final DelegatePlayerFactory playerFactory;

    public AbstractBase(Object plugin) {
        this.plugin = plugin;
        this.playerFactory = new DelegatePlayerFactory(this::resolveUniqueId, this::createPlayer);
    }

    @Override
    public final PlayerFactory playerFactory() {
        return playerFactory;
    }

    @Override
    public final int version() {
        return 1;
    }

    @Override
    public final <P> P plugin(Class<P> pluginClass) {
        return pluginClass.cast(plugin);
    }

    protected final PluginConfiguration loadConfiguration(JarFile pluginFile, Path configPath) throws IOException {
        if(Files.exists(configPath) && !Files.isDirectory(configPath)) {
            return new PluginConfiguration(YAML.loadAs(new String(Files.readAllBytes(configPath), StandardCharsets.UTF_8),
                    ConfigObject.class));
        }

        Files.deleteIfExists(configPath);
        Files.copy(pluginFile.getInputStream(pluginFile.getEntry("config.yml")), configPath);

        pluginFile.close();

        return new PluginConfiguration();
    }

    public abstract UUID resolveUniqueId(Object identifier);

    public abstract CaptchaPlayer createPlayer(UUID uniqueId);
}
