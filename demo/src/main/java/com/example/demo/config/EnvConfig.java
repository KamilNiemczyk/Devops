package com.example.demo.config;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory(".") // Wskaż katalog, gdzie znajduje się plik .env
            .load();

    public static String getEnv(String key) {
        return dotenv.get(key);
    }
}