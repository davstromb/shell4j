package com.github.davstromb.shell4j;

import com.github.davstromb.shell4j.shell.Shell;
import org.apache.commons.cli.*;

public class Shell4jApplication {


    public static void main(String... args) {
        Options options = new Options();
        options.addOption("verbose", "More details in logging. Disabled as default.");
        options.addOption("import",  "Enables import of external classes. Disabled as default.");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            Shell shell = new Shell(cmd.hasOption("verbose"), cmd.hasOption("import"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
