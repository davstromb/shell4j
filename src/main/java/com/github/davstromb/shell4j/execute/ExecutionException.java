package com.github.davstromb.shell4j.execute;

public class ExecutionException extends RuntimeException {

    public ExecutionException(String messageToUser, Exception e) {
        super(messageToUser, e);
    }

}
