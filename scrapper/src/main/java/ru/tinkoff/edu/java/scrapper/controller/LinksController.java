package ru.tinkoff.edu.java.scrapper.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.scrapper.model.request.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.model.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.scrapper.model.response.LinkResponse;
import ru.tinkoff.edu.java.scrapper.model.response.ListLinksResponse;

@RestController
public class LinksController implements Links {

    @Override
    public ResponseEntity<ListLinksResponse> getLinks(
            @Parameter(
                    in = ParameterIn.HEADER,
                    required = true, schema = @Schema())
            @RequestHeader(
                    value = "Tg-Chat-Id")
            Long tgChatId) {

        return new ResponseEntity<ListLinksResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<LinkResponse> postLinks(
            @Parameter(
                    in = ParameterIn.HEADER,
                    required = true,
                    schema = @Schema())
            @RequestHeader(
                    value = "Tg-Chat-Id")
            Long tgChatId,
            @Parameter(
                    in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema())
            @Valid
            @RequestBody
            AddLinkRequest body) {

        return new ResponseEntity<LinkResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<LinkResponse> deleteLinks(
            @Parameter(
                    in = ParameterIn.HEADER,
                    required = true,
                    schema = @Schema())
            @RequestHeader(
                    value = "Tg-Chat-Id")
            Long tgChatId,
            @Parameter(
                    in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema())
            @Valid
            @RequestBody
            RemoveLinkRequest body) {

        return new ResponseEntity<LinkResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
}
