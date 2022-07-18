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

        //Set parameters
        String url = "http://example.com";
        String charset = java.nio.charset.StandardCharsets.UTF_8.name(); // Or just "UTF-8"
        String param1 = "value1";
        String param2 = "value2";

        //Create the query
        String query = null;
        String URLWithQuery = null;
        try {
            query = String.format("param1=%s&param2=%s",
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset));
            URLWithQuery = url + "?" + query;
            System.out.println("Using the following url + query ["+URLWithQuery+"]");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Sending the query
        URLConnection connection = null;
        try {
            connection = new URL(URLWithQuery).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = null;
        try {
            response = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print response
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.print("Bellow this line is the response" +
                    "\n------------------------------------------------------------"+
                    responseBody+
                    "\n------------------------------------------------------------\n");
        }

        //Asserts
        boolean result;
        System.out.println("Finishing AppTest");
        result= TRUE; //@TODO: This is hardcoded for testing
        assertEquals("TestFail. ", true, result);

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
