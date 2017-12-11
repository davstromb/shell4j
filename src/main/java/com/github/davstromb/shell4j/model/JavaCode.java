package com.github.davstromb.shell4j.model;

import java.util.Objects;
import java.util.Random;

public class JavaCode implements Code {

    private final String codeAsString;

    public JavaCode(String codeAsString) {

        codeAsString = convertToAssignment(codeAsString);
        if(Objects.isNull(codeAsString)) {
            throw new CodeException("Code can not be null lol");
        }
        this.codeAsString = codeAsString;
    }

    private String convertToAssignment(String codeAsString) {
        if(! codeAsString.contains("=") || ((codeAsString.length() - codeAsString.replace("=", "").length()) % 2) == 0) {
            return "Object $_" + Math.abs(new Random().nextInt()) + " = " + codeAsString;
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
