package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.model.JavaCode;

public interface Executor {

    public void clean();

    public void addCode(JavaCode code);

    public String execute();

    public void print();

}
