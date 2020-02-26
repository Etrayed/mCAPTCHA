package de.etrayed.mcaptcha.verify.result;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.verify.VerificationMethod;
import de.etrayed.mcaptcha.verify.VerificationResult;

abstract class FailedVerificationResult implements VerificationResult {

    private final Class<? extends VerificationMethod> methodClass;

    private final boolean expired;

    private final CaptchaPlayer recipient;

    public FailedVerificationResult(Class<? extends VerificationMethod> methodClass, boolean expired,
                                    CaptchaPlayer recipient) {
        this.methodClass = methodClass;
        this.expired = expired;
        this.recipient = recipient;
    }

    @Override
    public final Class<? extends VerificationMethod> methodClass() {
        return methodClass;
    }

    @Override
    public final boolean isSuccessful() {
        return false;
    }

    @Override
    public final boolean hasFailed() {
        return true;
    }

    @Override
    public final boolean isExpired() {
        return expired;
    }

    @Override
    public final CaptchaPlayer recipient() {
        return recipient;
    }
}
