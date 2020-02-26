package de.etrayed.mcaptcha.verify.result;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.verify.VerificationMethod;
import de.etrayed.mcaptcha.verify.VerificationResult;

public final class SuccessfulVerificationResult implements VerificationResult {

    private final Class<? extends VerificationMethod> methodClass;

    private final CaptchaPlayer recipient;

    public SuccessfulVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient) {
        this.methodClass = methodClass;
        this.recipient = recipient;
    }

    @Override
    public Class<? extends VerificationMethod> methodClass() {
        return methodClass;
    }

    @Override
    public boolean isSuccessful() {
        return true;
    }

    @Override
    public boolean hasFailed() {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public CaptchaPlayer recipient() {
        return recipient;
    }
}
