package de.etrayed.mcaptcha.player;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.player.PlayerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DelegatePlayerFactory implements PlayerFactory {

    private final Map<UUID, CaptchaPlayer> playerCache = new ConcurrentHashMap<>();

    private final Function<Object, UUID> uniqueIdMapper;

    private final Function<UUID, CaptchaPlayer> playerMapper;

    public DelegatePlayerFactory(Function<Object, UUID> uniqueIdMapper, Function<UUID, CaptchaPlayer> playerMapper) {
        this.uniqueIdMapper = uniqueIdMapper;
        this.playerMapper = playerMapper;
    }

    @Override
    public CaptchaPlayer forUniqueId(UUID uniqueId) {
        return playerCache.computeIfAbsent(uniqueId, playerMapper);
    }

    @Override
    public CaptchaPlayer forUsername(String username) {
        return forPlayerObject(username);
    }

    @Override
    public CaptchaPlayer forPlayerObject(Object player) {
        return forUniqueId(uniqueIdMapper.apply(player));
    }
}
