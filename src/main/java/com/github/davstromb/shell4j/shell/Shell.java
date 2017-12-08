package com.github.davstromb.shell4j.shell;

import java.io.Console;
import java.util.Scanner;

public class Shell {
    private final boolean verbose;
    private final boolean importEverything;

    private final Scanner scanner;

    public Shell() {
        this(false, true);
    }

    public Shell(boolean verbose) {
        this(verbose, true);
    }

    public Shell(boolean verbose, boolean importEverything) {
        this.verbose = verbose;
        this.importEverything = importEverything;

        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            String input = readInput();
            if (isExitCommand(input)) {
                break;
            }
            System.out.println(input);
        }
    }

    private boolean isExitCommand(String input) {
        return input.equals("/quit");
    }

    private String readInput() {
        printPrompt();
        return scanner.nextLine();
    }

    private void printPrompt() {
        System.out.print(">");
    }

    public static void main(String[] args) {
        Shell s = new Shell();
        s.run();
    }
}
