package de.etrayed.mcaptcha.verify;

import de.etrayed.mcaptcha.player.CaptchaPlayer;

/**
 * @author Etrayed
 */
public interface VerificationResult {

    Class<? extends VerificationMethod> methodClass();

    boolean isSuccessful();

    boolean hasFailed();

    boolean isExpired();

    CaptchaPlayer recipient();
}
