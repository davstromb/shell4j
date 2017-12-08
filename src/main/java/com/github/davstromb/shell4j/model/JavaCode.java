package com.github.davstromb.shell4j.model;

import java.util.Objects;

public class JavaCode {


    public final String codeAsString;

    public JavaCode(String codeAsString) {
        if(Objects.isNull(codeAsString)) {
            throw new JavaCodeException("Code can not be null lol");
        }
        this.codeAsString = codeAsString;
    }

    public static JavaCode create(String codeAsString) {
        return new JavaCode(codeAsString);
    }
}
