package com.github.davstromb.shell4j.execute;

import com.github.davstromb.shell4j.execute.print.Printer;
import com.github.davstromb.shell4j.model.Code;
import com.github.davstromb.shell4j.model.JavaCode;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaExecutor implements Executor {

    private static final String CODE_PREFIX =
            "import java.util.*;\n" +
                    "\n" +
                    "public class Code {\n" +
                    "    \n" +
                    "    static {";
    private static final String CODE_SUFFIX = "    }" +
            "}";

    private StringBuilder cache;
    private List<Code> codes;

    public JavaExecutor() {
        this.codes = new ArrayList<>();
        this.cache = new StringBuilder();
    }

    public Executor clean() {
        this.codes = new ArrayList<>();
        this.cache = new StringBuilder();
        return this;
    }

    public Executor append(Code code) {
        int size = this.codes.size();
        if (size > 0) {
            this.cache.append(codes.get(size - 1).code());
        }
        codes.add(code);
        return this;
    }

    private String getExecuteString() {
        String code = this.codes.get(this.codes.size() - 1).code().trim();
        String toOutput = code.substring(0, code.length() - 1);
        String outputString = "System.out.println(" + toOutput + ");";
        return CODE_PREFIX + cache.toString() + outputString + CODE_SUFFIX;
    }

    public String execute() {
        try {
            String output = DynamicCompiler.create().run(getExecuteString());
            System.out.println(output);
        } catch (Exception e) {
            throw new ExecutionException("Could not write code to file lol", e);
        }
        return "";
    }

    private void deleteFile() throws IOException {
//        Files.delete(Paths.get(JAVA_BASE_FILE));
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

    public static void main(String[] args) {
        String code = JavaExecutor.create()
                .append(JavaCode.create("System.out.println(7);"))
                .execute();

    }
}
