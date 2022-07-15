package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This where the test cases are defined.
 */
public class JustUI

    extends TestCase {
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public JustUI(String testName ) throws InterruptedException {

        /** This make a web test*/
        boolean myWebPageResult = BasicBrowser.returnWebTestResult();
        assertEquals("Test failed. ", true, myWebPageResult);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JustUI.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
