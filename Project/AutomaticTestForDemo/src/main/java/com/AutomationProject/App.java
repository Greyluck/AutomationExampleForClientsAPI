package com.AutomationProject;

/**
 * This is the main class.
 * It is set in the pom.xml file bellow build/plugins/plugins/configuration/archive/manifest/main class
 * When the project is executed it will start with the main method of this class
 * Be aware of "AppTest.Java", the tests there will be launch too.
 */
public class App 
{
    public static void main( String[] args ) {
        calculateGenericInterest ();
    }

    /*This is a simple method to test the main*/
    public static void calculateGenericInterest () {
        double result = SimpleInterest.calculateSimpleInterest(10000, 5, 7);
        System.out.println("The simple interest is:" + result);
    }

    /*@TODO: This method is duplicated, check simple interest and find why it should be*/
    public static double calculateSimpleInterest(double amount,double years,double rate_of_interest) {
        double simple_interest;
        simple_interest = amount * years * rate_of_interest;
        return simple_interest;
    }

    /*@TODO: THIS METHOD SHOULD BE VALIDATED, IT IS NOT FINISHED YET*/
    public static boolean returnWebTestResult() throws InterruptedException {
        return BasicBrowser.executeSimpleUITest();
    }

}
