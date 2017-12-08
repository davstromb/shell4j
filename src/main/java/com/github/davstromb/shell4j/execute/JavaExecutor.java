package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.execute.print.Printer;
import com.github.davstromb.shell4j.model.JavaCode;

public class JavaExecutor implements Executor {


    private StringBuilder cache;

    public JavaExecutor() {
        this.cache = new StringBuilder();
    }

    public void clean() {
        this.cache = new StringBuilder();
    }

    public void addCode(JavaCode code) {
        this.cache.append(code.toString());
    }

    public String execute() {
        return null;
    }

    public void print() {
        Printer.create().save(cache);
    }
}
