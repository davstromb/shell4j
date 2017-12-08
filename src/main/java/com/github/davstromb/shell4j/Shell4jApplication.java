package com.github.davstromb.shell4j;

import com.github.davstromb.shell4j.shell.Shell;
import org.apache.commons.cli.*;

public class Shell4jApplication {


    public static void main(String... args) {
        Options options = new Options();
        Option verbose = new Option("v","verbose", false,"disabled as default");
        options.addOption(verbose);
        Option imp = new Option("i","import", false, "disabled as default");
        options.addOption(imp);
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            Shell shell = new Shell(cmd.hasOption("verbose"), cmd.hasOption("import"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
