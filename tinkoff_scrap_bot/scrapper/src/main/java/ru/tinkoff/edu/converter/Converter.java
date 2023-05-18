package ru.tinkoff.edu.converter;

import org.springframework.stereotype.Component;
import ru.tinkoff.edu.repository.jdbc.dto.Link;
import ru.tinkoff.edu.repository.jdbc.dto.TgChat;
import ru.tinkoff.edu.repository.jpa.entity.LinkEntity;
import ru.tinkoff.edu.repository.jpa.entity.TgChatEntity;
import ru.tinkoff.edu.response.LinkResponse;
import ru.tinkoff.edu.response.ListLinksResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class Converter {
    public LinkResponse linkToLinkResponse(Link link) {
        return new LinkResponse(link.getId(), link.getLink());
    }

    public ListLinksResponse linksToListLinksResponse(List<Link> links) {
        return new ListLinksResponse(links.stream().map(this::linkToLinkResponse).toList(), links.size());
    }

    public TgChat tgChatEntityToTgChat(TgChatEntity tgChatEntity) {
        return new TgChat(tgChatEntity.getId(), tgChatEntity.getTgChatId());
    }

    public Link linkEntityToLink(LinkEntity linkEntity) throws URISyntaxException {
        return new Link(linkEntity.getId(), new URI(linkEntity.getLink()), linkEntity.getLastUpdate(), linkEntity.getLastActivity(),
                linkEntity.getOpenIssuesCount(), linkEntity.getAnswerCount());
    }

    public LinkResponse linkEntityToLinkResponse(LinkEntity linkEntity) throws URISyntaxException {
        return new LinkResponse(linkEntity.getId(), new URI(linkEntity.getLink()));
    }

    public ListLinksResponse linkEntitiesToListLinksResponse(List<LinkEntity> links) {
        return new ListLinksResponse(links.stream().map((LinkEntity le) ->
        {
            try {
                return linkEntityToLinkResponse(le);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }).toList(), links.size());
    }
}
