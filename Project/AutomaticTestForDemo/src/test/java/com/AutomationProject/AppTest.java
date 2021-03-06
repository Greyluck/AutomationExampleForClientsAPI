package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * In this case a simple GET Request is sent to www.freetogame.com
 * The response is a list of games that follow the specified criteria.
 * the selected categories.
 */

public class AppTest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */

    public AppTest( String testName ){
        super( testName );

        //Definitions
        String gameName1 = "Diablo Immortal";

        //Start
        System.out.println("Starting api request Test");

        //Steps
        APIRequest myApiRequest = new APIRequest();
        myApiRequest.setURL("https://www.freetogame.com/api/games");
        myApiRequest.addParameters("platform","pc");
        myApiRequest.addParameters("category","mmorpg");
        myApiRequest.addParameters("sort-by","alphabetical");
        myApiRequest.executeGETApiRequest();
        myApiRequest.printRequestShortResponse(80);

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
