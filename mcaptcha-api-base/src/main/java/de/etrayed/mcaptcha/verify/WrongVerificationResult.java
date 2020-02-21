package de.etrayed.mcaptcha.verify;

import de.etrayed.mcaptcha.player.CaptchaPlayer;

public final class WrongVerificationResult extends FailedVerificationResult {

    public WrongVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient) {
        super(methodClass, false, recipient);
    }
}
