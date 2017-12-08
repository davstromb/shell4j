package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.model.JavaCode;

public interface Executor {

    public Executor clean();

    public Executor append(JavaCode code);

    public String execute();

    public Executor print();

}
