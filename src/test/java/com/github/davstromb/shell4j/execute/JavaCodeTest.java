package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.model.JavaCode;
import org.junit.Test;

public class JavaCodeTest {

    @Test
    public void test_code_variable() {
        JavaCode.create("a;");
    }
}
