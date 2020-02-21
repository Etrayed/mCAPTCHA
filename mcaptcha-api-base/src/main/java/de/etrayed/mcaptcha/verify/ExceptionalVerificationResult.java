package de.etrayed.mcaptcha.verify;

import de.etrayed.mcaptcha.player.CaptchaPlayer;

public final class ExceptionalVerificationResult extends FailedVerificationResult {

    private final Exception cause;

    public ExceptionalVerificationResult(Class<? extends VerificationMethod> methodClass, CaptchaPlayer recipient,
                                         Exception cause) {
        super(methodClass, false, recipient);

        this.cause = cause;
    }

    public Exception cause() {
        return cause;
    }
}
