package com.github.davstromb.shell4j;

import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hassan Shah
 * @organization Omegapoint AB
 */
public class Shell4jApplicationTest {

    @Test
    public void VerboseEnabledTest() {
        try{Shell4jApplication application = new Shell4jApplication();
        application.main("--verbose");
        } catch(Exception e) {
            Assert.fail("Failed to take \"--verbose\" as input argument");
        }
    }

    @Test
    public void ImportsEnabledTest() {
        try{Shell4jApplication application = new Shell4jApplication();
        application.main("--import");
        } catch(Exception e) {
            Assert.fail("Failed to take \"--import\" as input argument");
        }
    }

    @Test
    public void ImpoertsAndVerboseEnabledTest() {
        try{
            Shell4jApplication application = new Shell4jApplication();
            application.main("--verbose", "--import");
        } catch(Exception e) {
            Assert.fail("Failed to take \"--verbose\" and \"--import\" as input arguments");
        }
    }
}
