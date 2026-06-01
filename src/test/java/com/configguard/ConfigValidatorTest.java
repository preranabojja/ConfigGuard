package com.configguard;

import com.configguard.model.Config;
import com.configguard.validator.ConfigValidator;
import com.configguard.validator.ValidationResult;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigValidatorTest {

    @Test
    void validConfigShouldPass() {

        Config config = new Config();

        config.setServer("localhost");
        config.setPort(8080);
        config.setTimeout(30);

        ValidationResult result =
                ConfigValidator.validate(config);

        assertTrue(result.isValid());
        assertEquals(0, result.getErrors().size());
    }

    @Test
void emptyServerShouldFail() {

    Config config = new Config();

    config.setServer("");
    config.setPort(8080);
    config.setTimeout(30);

    ValidationResult result =
            ConfigValidator.validate(config);

    assertFalse(result.isValid());
}

@Test
void invalidPortShouldFail() {

    Config config = new Config();

    config.setServer("localhost");
    config.setPort(70000);
    config.setTimeout(30);

    ValidationResult result =
            ConfigValidator.validate(config);

    assertFalse(result.isValid());
}





}
