package com.github.davstromb.shell4j.model;

public class CodeException extends RuntimeException {

    public CodeException(String messageToUser, Exception e) {
        super(messageToUser, e);
    }

    public CodeException(String messageToUser) {
        super(messageToUser);
    }
}
