package de.etrayed.mcaptcha.player;

import de.etrayed.mcaptcha.verify.VerificationMethod;
import de.etrayed.mcaptcha.verify.VerificationResult;

import java.util.UUID;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Etrayed
 */
public interface CaptchaPlayer {

    UUID uniqueId();

    String username();

    boolean inVerificationProcess();

    boolean tryCancelVerification();

    VerificationResult verify(int methodType);

    void verifyAsync(int methodType, Consumer<VerificationResult> callback);

    Future<VerificationResult> verifyAsync(int methodType);

    VerificationResult verify(Function<CaptchaPlayer, VerificationMethod> customFunction);

    void verifyAsync(Function<CaptchaPlayer, VerificationMethod> customFunction, Consumer<VerificationResult> callback);

    Future<VerificationResult> verifyAsync(Function<CaptchaPlayer, VerificationMethod> customFunction);

    void sendTemplateMessage(String template);

    void sendRawMessage(String message);

    <P> P toPlayerObject(Class<P> playerClass);
}
