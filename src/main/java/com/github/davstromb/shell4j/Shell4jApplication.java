package com.github.davstromb.shell4j;

import org.apache.commons.cli.*;

public class Shell4jApplication {


    public static void main(String... args) {
        Options options = new Options();
        options.addOption("Verbose", "More details in logging. Disabled as default.");
        options.addOption("Import", "Enables import of external classes. Disabled as default.");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
