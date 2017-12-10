package com.github.davstromb.shell4j.model;

import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

public class JavaCode implements Code {

    private final String codeAsString;

    public JavaCode(String codeAsString) {

        codeAsString = makeStatement(codeAsString);
        if(Objects.isNull(codeAsString)) {
            throw new CodeException("Code can not be null lol");
        }
        this.codeAsString = codeAsString;
    }

    private String makeStatement(String codeAsString) {
        if(! codeAsString.contains("=")) {
            return "Object x" + Math.abs(new Random().nextInt()) + " = " + codeAsString;
        }

        return codeAsString;
    }

    public static JavaCode create(String codeAsString) {
        return new JavaCode(codeAsString);
    }

    @Override
    public String code() {
        return this.codeAsString;
    }
}
