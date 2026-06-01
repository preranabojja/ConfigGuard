package com.configguard.validator;

import com.configguard.model.Config;

public class ConfigValidator {

    public static ValidationResult validate(Config config) {

        ValidationResult result = new ValidationResult();

        if (config.getServer() == null ||
            config.getServer().trim().isEmpty()) {

            result.addError("Server cannot be empty");
        }

        if (config.getPort() < 1 ||
            config.getPort() > 65535) {

            result.addError("Port must be between 1 and 65535");
        }

        if (config.getTimeout() <= 0) {

            result.addError("Timeout must be greater than 0");
        }

        if (config.getTimeout() < 10) {

            result.addWarning("Timeout is unusually low");
        }

        if (config.getServer().contains(" ")) {
    result.addError(
        "Server name cannot contain spaces");
}

if (config.getTimeout() > 300) {
    result.addWarning(
        "Timeout is unusually high");
}

if (config.getPort() == 22) {
    result.addWarning(
        "Port 22 may require elevated permissions");
}

        return result;
    }
}
