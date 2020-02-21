package de.etrayed.mcaptcha.verify;

import de.etrayed.mcaptcha.player.CaptchaPlayer;

public final class ExpiredVerificationResult extends FailedVerificationResult {

    public ExpiredVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient) {
        super(methodClass, true, recipient);
    }
}
