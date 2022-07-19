package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** This where the test case is defined. */
public class AppTest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */

    public AppTest( String testName ) throws InterruptedException {
        super( testName );
        System.out.println("Starting Test");

        // Executing the request
        boolean step1 = APIRequest.executeGETApiRequest(
                "https://www.freetogame.com/api/games",
                "platform","pc",
                "category","mmorpg");
        //Asserts
        assertEquals("TestFail. ", true, step1);
        System.out.println("Test finished");
    }





    /** @return the suite of tests being tested */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /** Rigorous Test */
    public void testApp()
    {
        assertTrue( true );
    }
}
