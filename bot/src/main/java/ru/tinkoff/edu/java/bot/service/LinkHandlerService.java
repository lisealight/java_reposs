package ru.tinkoff.edu.java.bot.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Data
@Service
public class LinkHandlerService {

    private List<String> linkList = new ArrayList<>();

    public void add_link(String link) {
        linkList.add(link);
    }
    public List<String> getLinkList() {
        return linkList;
    }
}
