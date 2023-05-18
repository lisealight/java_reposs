package ru.tinkoff.edu.java.parser.result;

public record GitResRecord(String userName, String repository) implements ParseResultSeal {
    @Override
    public String getResult() {
        return userName + "/" + repository;
    }
}
