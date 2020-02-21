package de.etrayed.mcaptcha.player;

import java.util.UUID;

/**
 * @author Etrayed
 */
public interface PlayerFactory {

    CaptchaPlayer forUniqueId(UUID uniqueId);

    CaptchaPlayer forUsername(String username);

    CaptchaPlayer forPlayerObject(Class<?> playerClass);
}
