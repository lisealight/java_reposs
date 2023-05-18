package ru.tinkoff.edu.java.parser.result;

public record StackResRecord(String userId) implements ParseResultSeal {
    @Override
    public String getResult() {
        return userId;
    }
}
