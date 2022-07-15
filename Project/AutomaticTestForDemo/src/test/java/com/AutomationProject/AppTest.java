package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

/**
 * This where the test cases are defined.
 */
public class AppTest 
    extends TestCase {
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest( String testName ) throws InterruptedException {

        /** This part make a simple test*/
        super( testName );
        double result = SimpleInterest.calculateSimpleInterest(10000, 5, 7);
        System.out.println("The simple interest is:" + result);
        // Comment first line to Make it fail, comment second to make it succed
        assertEquals("TestFail. ", 350000.0, result);
        //assertEquals("TestFail. ", 35000.0, result);

        /** This make a web test*/
        boolean myWebPageResult = BasicBrowser.returnWebTestResult();
        assertEquals("Test failed. ", true, myWebPageResult);
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
