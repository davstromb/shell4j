package com.github.davstromb.shell4j.shell;

import com.github.davstromb.shell4j.execute.Executor;
import com.github.davstromb.shell4j.execute.JavaExecutor;
import com.github.davstromb.shell4j.model.JavaCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Shell {
    private final boolean verbose;
    private final boolean importEverything;

    private final char CMD_CHAR = '/';

    private final Scanner  scanner  = new Scanner(System.in);
    private final Executor executor = new JavaExecutor();

    public Shell() {
        this(false, false);
    }

    public Shell(boolean verbose) {
        this(verbose, true);
    }

    public Shell(boolean verbose, boolean importEverything) {
        this.verbose = verbose;
        this.importEverything = importEverything;
    }

    public void run() {
        Statement statement = new Statement();

        printPrompt();
        shell_loop: while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (isCommand(input)) {
                switch (input.substring(1)) {
                    case "delete" : executor.clean(); break;
                    case "save": save(); break;
                    case "help": printHelp(); break;
                    case "quit": save();
                    case "ragequit": break shell_loop;
                    case "lol": lol(); break;
                    default:
                        System.out.println("Command (" + input + ") not recognized");
                }

                printPrompt();
            } else {
                statement.add(input);
                if (statement.isComplete()) {
                    System.out.println(statement);

                    executor.append(new JavaCode(statement.toString()));
                    String res = executor.execute();
                    System.out.println(res);

                    statement = new Statement();
                    printPrompt();
                } else {
                    statement.add(" ");
                    printContinuationPrompt();
                }
            }
        }

        System.out.println("Goodbye!");
    }

    private void printHelp() {
        System.out.println("available commands:");
        System.out.println("/quit");
        System.out.println("/ragequit");
        System.out.println("/save");
        System.out.println("/help");
        System.out.println("/delete");
    }

    private void printContinuationPrompt() {
        System.out.print("    ...> ");
    }

    private void printPrompt() {
        System.out.print("shell4j> ");
    }

    private void save() {
        System.out.println("Saving session.... (not implemented)");
    }

    private boolean isCommand(String input) {
        return input.startsWith(String.valueOf(CMD_CHAR));
    }

    private void lol() {
        Path path = Paths.get("src/main/resources/lol.txt");
        try {
            Files.readAllLines(path).forEach(l -> System.out.println(l));
        } catch (IOException e) {
            System.out.println("Sry, no lol :(");
        }
    }

    public static void main(String[] args) {
        Shell s = new Shell();
        s.run();
    }
}