package com.AutomationProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** This is where the test case is defined. */
public class UITest extends TestCase {
    /** Create the test case
     * @param testName name of the test case
     */
    public UITest(String testName ) throws InterruptedException {

        // WebElements Xpath
        String browseGamesButton =  "//a[contains(text(),'Browse Games')]";
        String platformComboBox =   "//a[contains(text(),'All Platforms ')]";
        String platformPCMenuItem = "//a[contains(text(),'Windows (PC)')]";
        String genreComboBox =      "//a[contains(text(),'All Genres')]";
        String genreRPGMenuItem =   "//a[contains(text(),'MMORPG')]";
        String gameName =           "//a[contains(text(),'Diablo Immortal')]";

        // Steps
        System.out.println("Starting selenium Test");
        SeleniumBrowser myBrowser = new SeleniumBrowser();
        myBrowser.start();
        myBrowser.findByXPathAndClickOnElement(browseGamesButton);
        myBrowser.findByXPathAndClickOnElement(platformComboBox);
        myBrowser.findByXPathAndClickOnElement(platformPCMenuItem);
        myBrowser.findByXPathAndClickOnElement(genreComboBox);
        myBrowser.findByXPathAndClickOnElement(genreRPGMenuItem);

        /** This make a web test*/
        assertEquals("The game is not present.", true, myBrowser.findByXPathAndCheckIfExists(gameName));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( UITest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
