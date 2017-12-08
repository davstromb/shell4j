package com.github.davstromb.shell4j.execute.print;

public class Printer {


    public static Printer create() {
        return new Printer();
    }

    public void save(StringBuilder cache) {
        System.out.println(cache.toString());
    }
}
