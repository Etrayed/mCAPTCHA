package de.etrayed.mcaptcha.spigot;

import de.etrayed.mcaptcha.AbstractBase;
import de.etrayed.mcaptcha.player.CaptchaPlayer;

import java.util.UUID;

public final class SpigotBase extends AbstractBase {

    public SpigotBase(Object plugin) {
        super(plugin);
    }

    @Override
    public UUID resolveUniqueId(Object identifier) {
        return null;
    }

    @Override
    public CaptchaPlayer createPlayer(UUID uniqueId) {
        return null;
    }
}
