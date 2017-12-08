package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.execute.print.Printer;
import com.github.davstromb.shell4j.model.JavaCode;

import java.io.IOException;
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
            throw new ExecutionException("Can not read java base code lol", e);
        }

    }

    public Executor clean() {
        this.cache = new StringBuilder();
        return this;
    }

    public Executor append(JavaCode code) {
        this.cache.append(code.toString());
        return this;
    }

    public String execute() {
        try {
            deleteFile();
            Files.write(Paths.get("Code.java"), cache.toString().getBytes());
        } catch (Exception e) {
            throw new ExecutionException("Could not write code to file lol", e);
        }
        return "";
    }

    private void deleteFile() throws IOException {
        Files.delete(Paths.get("Code.java"));
    }

    public Executor print() {
        Printer.create().save(cache);
        return this;
    }

    @Override
    public String getCode() {
        return cache.toString();
    }

    public static Executor create() {
        return new JavaExecutor();
    }
}
