package de.etrayed.mcaptcha.config;

import de.etrayed.mcaptcha.verify.VerificationMethod;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class PluginConfiguration {

    private static final String PRE_DEF_METHODS_PACKAGE = "de.etrayed.mcaptcha.verify.predef.";

    private final List<VerificationMethod> enabledMethods = new CopyOnWriteArrayList<>();

    private boolean joinCheckEnabled, commandEnabled;

    public PluginConfiguration() {
        this(new ConfigObject());
    }

    public PluginConfiguration(ConfigObject object) {
        this.joinCheckEnabled = object.joinCheckEnabled;
        this.commandEnabled = object.commandEnabled;

        object.enabledMethods.stream().map(this::normalizePath).forEach(this::enableMethod);
    }

    private String normalizePath(String path) {
        if(path.charAt(0) != '~') {
            return path;
        }

        return PRE_DEF_METHODS_PACKAGE + path.substring(1);
    }

    private void enableMethod(String path) {
        try {
            Class<?> pathClass = Class.forName(path);

            if (!VerificationMethod.class.isAssignableFrom(pathClass)) {
                throw new IllegalArgumentException("Error loading configuration: '" + path + "' does not implement "
                        + VerificationMethod.class.getCanonicalName());
            }

            enabledMethods.add((VerificationMethod) Class.forName(path).newInstance());
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Error loading configuration: Class '" + path + "' is not defined");
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Error loading configuration: Invalid constructor in '" + path + "'");
        }
    }

    public List<VerificationMethod> listEnabledMethods() {
        return enabledMethods;
    }

    public boolean isJoinCheckEnabled() {
        return joinCheckEnabled;
    }

    public boolean isCommandEnabled() {
        return commandEnabled;
    }

    public void enableJoinCheck() {
        this.joinCheckEnabled = true;
    }

    public void disableJoinCheck() {
        this.joinCheckEnabled = false;
    }

    public void enableCommand() {
        this.commandEnabled = true;
    }

    public void disableCommand() {
        this.commandEnabled = false;
    }
}
