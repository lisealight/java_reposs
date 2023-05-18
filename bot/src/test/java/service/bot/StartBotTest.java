package service.bot;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tinkoff.edu.java.bot.configuration.TelegramConfig;
import ru.tinkoff.edu.java.bot.service.LinkHandlerService;
import ru.tinkoff.edu.java.bot.service.bot.StartBot;
import ru.tinkoff.edu.java.bot.service.commands.CommandList;
import ru.tinkoff.edu.java.bot.service.commands.implement.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartBotTest {
    @InjectMocks
    private StartBot startBot;
    @Mock
    private TelegramConfig telegramConfig;
    @Spy
    private CommandList commandList = new CommandList(
            new StartCommand(),
            new HelpCommand(),
            new TrackCommand(new LinkHandlerService()),
            new UntrackCommand(),
            new ListCommand(new LinkHandlerService()));
    @Mock
    private Update update;
    @Mock
    private Message message;
    @Mock
    private Chat chat;

    @Test
    void handleByCommand_shouldReturnListCommand() {
        String listCommandAnswer = ListCommand.getLINK_LIST_IS_EMPTY();

        when(message.text()).thenReturn("/list");
        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(update.message()
                   .chat()
                   .id()).thenReturn(1L);

        SendMessage sendMessage = startBot.handleByCommand(update, message);
        assertAll(
                () -> assertThat(sendMessage.getParameters()).extracting("chat_id")
                                                             .isEqualTo(1L),
                () -> assertThat(sendMessage.getParameters()).extracting("text")
                                                             .isEqualTo(listCommandAnswer)
        );
    }

    @Test
    void handleByCommand_shouldReturnUnknownCommand() {
        String unknownCommand = UnknownCommand.getUNKNOWN_COMMAND();

        when(message.text()).thenReturn("/random_command");
        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(update.message()
                   .chat()
                   .id()).thenReturn(1L);

        SendMessage sendMessage = startBot.handleByCommand(update, message);
        assertAll(
                () -> assertThat(sendMessage.getParameters()).extracting("chat_id")
                                                             .isEqualTo(1L),
                () -> assertThat(sendMessage.getParameters()).extracting("text")
                                                             .isEqualTo(unknownCommand)
        );
    }
}