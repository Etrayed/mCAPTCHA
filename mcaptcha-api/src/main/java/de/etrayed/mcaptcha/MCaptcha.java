package de.etrayed.mcaptcha;

import de.etrayed.mcaptcha.player.PlayerFactory;

/**
 * @author Etrayed
 */
public interface MCaptcha {

    PlayerFactory playerFactory();

    int version();

    <P> P plugin(Class<P> pluginClass);
}
