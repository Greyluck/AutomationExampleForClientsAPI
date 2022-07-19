package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.InputStream;

/** This is where the test case is defined. */
public class AppTest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */

    // This test will perform the search of a Game in a web page.
    public AppTest( String testName ){
        super( testName );

        //Definitions
        String gameName1 = "Diablo Immortal";

        //Start
        System.out.println("Starting api request Test");

        //Steps
        APIRequest myApiRequest = new APIRequest();
        myApiRequest.setURL("https://www.freetogame.com/api/games");
        myApiRequest.setParameters(
                "platform","pc",
                "category","mmorpg");
        myApiRequest.concatenateURLWithQuery();
        myApiRequest.executeGETApiRequest();
        myApiRequest.printRequestResponse();

        //Asserts
        assertEquals("The response is Null.", true, myApiRequest.validateResponseExist());
        assertEquals("The game is not there", true, myApiRequest.validateTextExistsInResponse(gameName1));
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
