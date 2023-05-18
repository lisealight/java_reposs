package ru.tinkoff.edu.java.bot.service.commands.implement;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.service.LinkHandlerService;
import ru.tinkoff.edu.java.bot.service.commands.Command;

@Component
public class TrackCommand implements Command {

    private final LinkHandlerService linkHandlerService;


    public TrackCommand(LinkHandlerService linkHandlerService) {
        this.linkHandlerService = linkHandlerService;
    }

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "начать отслеживание ссылки";
    }

    @Override
    public SendMessage handle(Update update) {
        linkHandlerService.add_link("link313");
        return new SendMessage(update.message().chat().id(),"ссылка ослеживается");
    }
}
