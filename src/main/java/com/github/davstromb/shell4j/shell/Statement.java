package com.github.davstromb.shell4j.shell;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Statement {
    private final StringBuilder statement = new StringBuilder();

    private int openedBlocks = 0;

    static final String keywords[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

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

    public boolean isVariable() {
        final String s = statement.toString();

        boolean isJavaVariable = Pattern.matches("^[a-zA-Z_$][a-zA-Z_$0-9]*$", s);
        boolean isJavaKeyword  = Arrays.binarySearch(keywords, s) >= 0;

        return isJavaVariable && !isJavaKeyword;
    }

    @Override
    public String toString() {
        return statement.toString();
    }

}
