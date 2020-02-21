package de.etrayed.mcaptcha;

import de.etrayed.mcaptcha.player.DelegatePlayerFactory;
import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.player.PlayerFactory;

import java.util.UUID;

public abstract class AbstractBase implements MCaptcha {

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

    public abstract UUID resolveUniqueId(Object identifier);

    public abstract CaptchaPlayer createPlayer(UUID uniqueId);
}
