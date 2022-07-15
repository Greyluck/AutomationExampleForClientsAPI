package com.AutomationProject;

/**
 * This class exists only the calculate an interest.
 * (Its main utility is to be used to test the main class)
 */
public class SimpleInterest{
    public static double calculateSimpleInterest(double amount,double years,double rate_of_interest) {
        double simple_interest;
        simple_interest = amount * years * rate_of_interest;
        return simple_interest;
    }
}