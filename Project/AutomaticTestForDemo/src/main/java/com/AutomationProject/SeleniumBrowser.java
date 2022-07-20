package com.AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class SeleniumBrowser {
    private static WebDriver driver = null;
    static int sleepTime = 2000;
    static int loadTime  = 1500;
    static String chromeDriverPath= ".\\Driver\\chromedriver.exe";
    static void main(String[] args){
    }

    void setup(String theStartingPage) throws InterruptedException {
        System.out.println("Executing Basic Browser");

        // set chromeDriver path
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();

        //TODO: set chromeDrive waits
        //driver.manage().timeouts().implicitlyWait(sleepTime);

        // open the web app
        driver.manage().window().maximize();
        driver.navigate().to(theStartingPage);
        Thread.sleep(0,loadTime);
    }

    public static void findByXPathAndClickOnElement(String xpath){
        WebElement myWebElement;
        myWebElement = driver.findElement(By.xpath(xpath));
        myWebElement.click();
    }

    //TODO: Add find by ID too
    public static boolean findByXPathAndCheckIfExists(String xpath){
        boolean isPresent;
        try {
            driver.findElement(By.xpath(xpath));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }

}
