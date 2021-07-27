package br.com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.net.URL;

public class FixtureUtils {
    private static final String FORMAT_JSON_FIXTURE_PATH = "file:src/test/resources/%s";
    public static <T> T parseObject(String file, Class<T> clazz) throws IOException {
        var objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

        return objectMapper.readValue(new URL(String.format(FORMAT_JSON_FIXTURE_PATH, file)), clazz);
    }
}
