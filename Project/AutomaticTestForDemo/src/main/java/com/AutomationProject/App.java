package com.AutomationProject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    }

    public static boolean returnWebTestResult() throws InterruptedException {
        return LaunchBrowser.executeMainTest();
    }
}
