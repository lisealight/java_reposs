package ru.tinkoff.edu.java.parser.links;

import ru.tinkoff.edu.java.parser.result.GitResRecord;
import ru.tinkoff.edu.java.parser.result.ParseResultSeal;

public final class GitHubLinkParse extends LinkParse {
    @Override
    public ParseResultSeal check(String link) {
        String[] splitLink = link.split("/");
        if (splitLink[2].equals("github.com") && splitLink.length > 4) {
            return new GitResRecord(splitLink[3], splitLink[4]);
        }
        return checkNext(link);
    }
}
