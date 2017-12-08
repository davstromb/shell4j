package com.github.davstromb.shell4j.model;

public class JavaCodeException extends RuntimeException {

    public JavaCodeException(String messageToUser, Exception e) {
        super(messageToUser, e);
    }
}
