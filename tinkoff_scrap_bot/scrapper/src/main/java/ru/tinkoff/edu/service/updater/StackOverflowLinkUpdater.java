package ru.tinkoff.edu.service.updater;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.record.StackOverflowRecord;
import ru.tinkoff.edu.repository.jdbc.dto.Link;
import ru.tinkoff.edu.response.QuestionResponse;
import ru.tinkoff.edu.service.LinkManipulator;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.sender.LinkUpdateSender;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@AllArgsConstructor
@Service
public class StackOverflowLinkUpdater implements LinkUpdater {
    private final LinkService linkService;
    private final LinkManipulator linkManipulator;
    private final LinkUpdateSender linkUpdateSender;

    @Override
    public void update(Link link) {
        QuestionResponse response = linkManipulator.getResponse((StackOverflowRecord) linkManipulator.getRecord(link));
        link.setLastUpdate(OffsetDateTime.now(ZoneId.systemDefault()));
        if (!response.answer_count().equals(link.getAnswerCount())) {
            link.setLastActivity(response.last_activity_date());
            link.setAnswerCount(response.answer_count());
            linkUpdateSender.sendUpdate(link, "In question '" + response.question_id() + "' new answers have been added!");
        } else if (response.last_activity_date().isAfter(link.getLastActivity())) {
            link.setLastActivity(response.last_activity_date());
            linkUpdateSender.sendUpdate(link, "Question '" + response.question_id() + "' has updates!");
        }
        linkService.updateLink(link);
    }
}
