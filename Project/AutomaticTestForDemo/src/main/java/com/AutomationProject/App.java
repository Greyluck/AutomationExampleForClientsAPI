package com.AutomationProject;

/**
 * This is the main class.
 * It is set in the pom.xml file bellow build/plugins/plugins/configuration/archive/manifest/main class
 * It will be executed when Maven starts.
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("HelloWorld");
    }


    public static boolean returnWebTestResult() throws InterruptedException {
        return BasicBrowser.executeSimpleUITest();
    }

}
