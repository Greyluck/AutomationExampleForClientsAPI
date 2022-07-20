package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * In this case a simple GET Request is sent to the following page
 * https://rapidapi.com/edamam/api/recipe-search-and-diet/
 * The response is will be a list of recipes
 * Then a recipe is verified to exist in that list
 */

public class DietTest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */

    public DietTest(String testName ){
        super( testName );

        //Definitions
        String recipeName = "Chicken Vesuvio";
        String[] headerKey = new String[]{"X-RapidAPI-Key","27b90e1ee9msha5d13334ef8323dp148d61jsn61a87e85ca77"};
        String[] host = new String[]{"X-RapidAPI-Host", "edamam-recipe-search.p.rapidapi.com"};

        //Start
        System.out.println("Starting api request Test");

        //Steps
        APIRequest myApiRequest = new APIRequest();
        myApiRequest.setURL("https://edamam-recipe-search.p.rapidapi.com/search");
        myApiRequest.addParameters("q","chicken");
        myApiRequest.addHeader(headerKey[0],headerKey[1]);
        myApiRequest.addHeader(host[0],host[1]);
        myApiRequest.executeGETApiRequest();
        myApiRequest.printRequestShortResponse(80);

        //Asserts
        assertEquals("The response is Null.", true, myApiRequest.validateResponseExist());
        assertEquals("The game is not there", true, myApiRequest.validateTextExistsInResponse(recipeName));
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
