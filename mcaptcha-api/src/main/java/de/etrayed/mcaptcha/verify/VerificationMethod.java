package de.etrayed.mcaptcha.verify;

import de.etrayed.mcaptcha.player.CaptchaPlayer;

/**
 * @author Etrayed
 */
@FunctionalInterface
public interface VerificationMethod {

    VerificationResult invoke(CaptchaPlayer player);
}
