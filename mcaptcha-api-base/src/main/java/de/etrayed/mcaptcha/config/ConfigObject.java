package de.etrayed.mcaptcha.config;

import java.util.Collections;
import java.util.List;

public final class ConfigObject {

    public boolean joinCheckEnabled = true, commandEnabled = true;

    public List<String> enabledMethods = Collections.emptyList();
}
