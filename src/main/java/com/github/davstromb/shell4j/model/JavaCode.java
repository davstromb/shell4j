package com.github.davstromb.shell4j.model;

import java.util.Objects;

public class JavaCode {


    private final String codeAsString;

    public JavaCode(String codeAsString) {
        if(Objects.isNull(codeAsString)) {
            throw new JavaCodeException("Code can not be null lol");
        }
        this.codeAsString = codeAsString;
    }
}
