package de.etrayed.mcaptcha.verify.result;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.verify.VerificationMethod;

public final class ExpiredVerificationResult extends FailedVerificationResult {

    public ExpiredVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient) {
        super(methodClass, true, recipient);
    }
}
