package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * This where the test case is defined.
 */
public class AppTest

    extends TestCase {
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest( String testName ) throws InterruptedException {
        super( testName );
        System.out.println("Starting AppTest");

        boolean step1 = APIRequest.executeApiRequest(
                "https://www.freetogame.com/api/games",
                "example",
                "example");
        //Asserts
        System.out.println("Finishing AppTest");
        assertEquals("TestFail. ", true, step1);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
