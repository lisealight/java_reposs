package ru.tinkoff.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.configuration.ApplicationConfig;
import ru.tinkoff.edu.model.Bot;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run(BotApplication.class, args);
        new Bot("6276397167:AAELHBYnPozXqT3ewWhYF3jDWoCOAZ-YzNk");
    }
}
