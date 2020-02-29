package de.etrayed.mcaptcha.spigot.player;

import de.etrayed.mcaptcha.player.CaptchaPlayer;
import de.etrayed.mcaptcha.verify.VerificationMethod;
import de.etrayed.mcaptcha.verify.VerificationResult;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

public final class SpigotCaptchaPlayer implements CaptchaPlayer {

    private final Player player;

    public SpigotCaptchaPlayer(Player player) {
        this.player = player;
    }

    @Override
    public UUID uniqueId() {
        return null;
    }

    @Override
    public String username() {
        return null;
    }

    @Override
    public boolean inVerificationProcess() {
        return false;
    }

    @Override
    public boolean tryCancelVerification() {
        return false;
    }

    @Override
    public VerificationResult verify(int methodType) {
        return null;
    }

    @Override
    public void verifyAsync(int methodType, Consumer<VerificationResult> callback) {

    }

    @Override
    public Future<VerificationResult> verifyAsync(int methodType) {
        return null;
    }

    @Override
    public VerificationResult verify(Function<CaptchaPlayer, VerificationMethod> customFunction) {
        return null;
    }

    @Override
    public void verifyAsync(Function<CaptchaPlayer, VerificationMethod> customFunction, Consumer<VerificationResult> callback) {

    }

    @Override
    public Future<VerificationResult> verifyAsync(Function<CaptchaPlayer, VerificationMethod> customFunction) {
        return null;
    }

    @Override
    public void sendTemplateMessage(String template) {

    }

    @Override
    public void sendRawMessage(String message) {

    }

    @Override
    public <P> P toPlayerObject(Class<P> playerClass) {
        return null;
    }
}
