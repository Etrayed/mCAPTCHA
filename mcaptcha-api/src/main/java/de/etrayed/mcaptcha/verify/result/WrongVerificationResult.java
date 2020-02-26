package de.etrayed.mcaptcha.verify.result;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.verify.VerificationMethod;

public final class WrongVerificationResult extends FailedVerificationResult {

    public WrongVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient) {
        super(methodClass, false, recipient);
    }
}
