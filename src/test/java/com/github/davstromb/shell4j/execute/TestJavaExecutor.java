package com.github.davstromb.shell4j.execute;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class TestJavaExecutor {

    @Test
    public void testExecutorInit() throws Exception{
        String sourceCode = JavaExecutor.create().print().getCode();




//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, code);
    }

}
