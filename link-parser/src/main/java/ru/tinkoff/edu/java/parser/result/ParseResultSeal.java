package ru.tinkoff.edu.java.parser.result;

public sealed interface ParseResultSeal permits GitResRecord, StackResRecord {
    String getResult();
}