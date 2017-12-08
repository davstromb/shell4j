package com.github.davstromb.shell4j.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class JavaCode implements Code {

    private final String codeAsString;

    public JavaCode(String codeAsString) {
        if(Objects.isNull(codeAsString)) {
            throw new CodeException("Code can not be null lol");
        }
        this.codeAsString = codeAsString;
    }

    public static JavaCode create(String codeAsString) {
        return new JavaCode(codeAsString);
    }

    @Override
    public String code() {
        return this.codeAsString;
    }
}
