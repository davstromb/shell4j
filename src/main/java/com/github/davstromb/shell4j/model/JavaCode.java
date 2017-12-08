package com.github.davstromb.shell4j.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class JavaCode implements Code {

    private static final String VARIABLE_REGEX = "^[a-zA-Z_$][a-zA-Z_$0-9]*$";
    public final String codeAsString;

    public JavaCode(String codeAsString) {
        if(Objects.isNull(codeAsString)) {
            throw new CodeException("Code can not be null lol");
        }

        Pattern p = Pattern.compile(VARIABLE_REGEX);
        if (p.matcher(codeAsString).matches()) {
            System.out.println("Found variable: [" + codeAsString + "]");
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
