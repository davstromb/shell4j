package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.execute.print.Printer;
import com.github.davstromb.shell4j.model.JavaCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaExecutor implements Executor {


    public static final String JAVA_BASE_TXT = "/JavaBase.txt";
    private StringBuilder cache;

    public JavaExecutor() {
        try {
            this.cache = new StringBuilder(new String(
                    Files.readAllBytes(
                            Paths.get(getClass().getResource(JAVA_BASE_TXT).toURI())))
            );
        } catch(Exception e) {
            throw new ExecutionException("Can not execute", e);
        }

    }

    public void clean() {
        this.cache = new StringBuilder();
    }

    public void addCode(JavaCode code) {
        this.cache.append(code.toString());
    }

    public String execute() {
        return "";
    }

    public void print() {
        Printer.create().save(cache);
    }
}
