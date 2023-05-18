package ru.tinkoff.edu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.service.TgChatService;

@AllArgsConstructor
@RestController
@RequestMapping("/tg-chat")
public class TgChatController {
    private final TgChatService service;

    @PostMapping(value = "/{id}")
    public void registerChat(@PathVariable("id") Long id) {
        service.register(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteChat(@PathVariable("id") Long id) {
        service.unregister(id);
    }
}
