package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * In this case a simple query is sent to www.freetogame.com page to check if a specific game matches
 * the selected categories.
 */

public class DietTest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */

    public DietTest(String testName ){
        super( testName );

        //Definitions
        String gameName1 = "Chicken Vesuvio";
        String[] headerKey = new String[]{"X-RapidAPI-Key","27b90e1ee9msha5d13334ef8323dp148d61jsn61a87e85ca77"};
        String[] host = new String[]{"X-RapidAPI-Host", "edamam-recipe-search.p.rapidapi.com"};

        //Start
        System.out.println("Starting api request Test");

        //Steps
        APIRequest myApiRequest = new APIRequest();
        myApiRequest.setURL("https://edamam-recipe-search.p.rapidapi.com/search");
        myApiRequest.addParameters("q","chicken");

        //TODO ADD METHODS
        //myApiRequest.addHeader(headerKey[0],headerKey[1]);
        //myApiRequest.addHeader(host[0],host[1]);

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
        return new TestSuite( DietTest.class );
    }

    /** Rigorous Test */
    public void testApp()
    {
        assertTrue( true );
    }
}
