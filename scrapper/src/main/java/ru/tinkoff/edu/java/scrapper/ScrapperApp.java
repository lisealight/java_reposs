package ru.tinkoff.edu.java.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperApp {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScrapperApp.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}