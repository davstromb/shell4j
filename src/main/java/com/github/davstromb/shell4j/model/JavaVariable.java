package com.github.davstromb.shell4j.model;

public class JavaVariable implements Code {

    private final String variableAsString;

    public JavaVariable(String variableAsString) {
        this.variableAsString = variableAsString + "=" + variableAsString + ";";
        int y = 8;
    }

    @Override
    public String code() {
        return this.variableAsString;
    }
}
