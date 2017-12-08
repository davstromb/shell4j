package com.github.davstromb.shell4j.shell;

import com.github.davstromb.shell4j.execute.Executor;
import com.github.davstromb.shell4j.execute.JavaExecutor;
import com.github.davstromb.shell4j.model.JavaCode;

import java.util.Scanner;

public class Shell {
    private final boolean verbose;
    private final boolean importEverything;

    private final char CMD_CHAR = '/';

    private final Scanner  scanner  = new Scanner(System.in);
    private final Executor executor = new JavaExecutor();

    public Shell() {
        this(false, true);
    }

    public Shell(boolean verbose) {
        this(verbose, true);
    }

    public Shell(boolean verbose, boolean importEverything) {
        this.verbose = verbose;
        this.importEverything = importEverything;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();

        printPrompt();
        shell_loop: while (true) {
            String input = readInput();
            if (isCommand(input)) {
                switch (input.substring(1)) {
                    case "save": save(); break;
                    case "exit": save(); break shell_loop;
                    default:
                        System.out.println("Command (" + input + ") not recognized");
                }

                printPrompt();
            } else {
                sb.append(input);
                if (isFinishedStatement(sb)) {
                    System.out.println(sb);

                    JavaCode code = new JavaCode(sb.toString());
                    executor.append(code);

                    sb = new StringBuilder();
                    printPrompt();
                } else {
                    sb.append(" ");
                    printContinuationPrompt();
                }
            }
        }

        System.out.println("Goodbye!");
    }

    private void printContinuationPrompt() {
        System.out.print("    ...> ");
    }

    private boolean isFinishedStatement(StringBuilder sb) {
        return sb.toString().endsWith(";");
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private void printPrompt() {
        System.out.print("shell4j> ");
    }

    private void save() {
        // TODO: 2017-12-08
        System.out.println("Saving session to file...");
    }

    private boolean isCommand(String input) {
        return input.startsWith(String.valueOf(CMD_CHAR));
    }

    public static void main(String[] args) {
        Shell s = new Shell();
        s.run();
    }
}