package ru.tinkoff.edu.java.parser.links;

import ru.tinkoff.edu.java.parser.result.ParseResultSeal;
import ru.tinkoff.edu.java.parser.result.StackResRecord;

public final class StackOverflowLinkParse extends LinkParse {
    @Override
    public ParseResultSeal check(String link) {
        String[] splitLink = link.split("/");
        if (splitLink[2].equals("stackoverflow.com") && splitLink.length > 4 && splitLink[3].equals("questions")) {
            return new StackResRecord(splitLink[4]);
        }
        return checkNext(link);
    }
}