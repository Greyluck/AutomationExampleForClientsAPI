package com.AutomationProject;

/**
 * This is the main class.
 * It is set in the pom.xml file bellow build/plugins/plugins/configuration/archive/manifest/main class
 * When the project is executed it will start with the main method of this class
 * If you start the test with the maven command "mvn test", this will be skipped.
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Running the main app");
        System.out.println("This won't execute test cases. Use the 'mvn test' command.");
        System.out.println("Main app has finished");
    }
}
