package ru.tinkoff.edu.java.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import ru.tinkoff.edu.java.bot.service.bot.StartBot;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApp {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApp.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
        StartBot startBot = ctx.getBean(StartBot.class);
        startBot.start();
    }

}
