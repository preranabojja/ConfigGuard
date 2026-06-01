package com.configguard.parser;

import com.configguard.model.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigParser {

    public static Config parse(String filePath) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                new File(filePath),
                Config.class
        );
    }
}
