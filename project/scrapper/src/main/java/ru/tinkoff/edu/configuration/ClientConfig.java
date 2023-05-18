package ru.tinkoff.edu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.client.BotClient;
import ru.tinkoff.edu.client.GitHubClient;
import ru.tinkoff.edu.client.StackOverflowClient;

@Configuration
public class ClientConfig {

    @Bean("gitHubClient")
    public GitHubClient gitHubClient() {
        return new GitHubClient();
    }

    @Bean("stackOverflowClient")
    public StackOverflowClient stackOverflowClient() {
        return new StackOverflowClient();
    }

    @Bean("botClient")
    public BotClient botClient() {
        return new BotClient();
    }
}
