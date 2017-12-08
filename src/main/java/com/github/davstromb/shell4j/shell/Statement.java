package com.github.davstromb.shell4j.shell;

public class Statement {
    private final StringBuilder statement;

    private int openedBlocks = 0;

    public Statement() {
        this.statement = new StringBuilder();
    }

    public void add(String input) {
        for (char c : input.toCharArray()) {
            if (c == '{') { openedBlocks++; }
            if (c == '}') { openedBlocks--; }
        }
        statement.append(input);
    }

    public boolean isComplete() {
        return (statement.toString().endsWith(";") || statement.toString().endsWith("}"))
                && openedBlocks < 1;
    }

    @Override
    public String toString() {
        return statement.toString();
    }
}
