package com.AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumBrowser {
    public static WebDriver driver = null;
    public static int sleepTime = 1000;
    public static int loadTime  = 1500;
    public static String chromeDriverPath= ".\\Driver\\chromedriver.exe";
    public static String startingPage = "https://www.freetogame.com/";
    public static String mainSearchXPath = "https://www.freetogame.com/";
    public static void main(String[] args){
    }

    public static void start() throws InterruptedException {
        System.out.println("Executing Basic Browser");

        // set chromeDriver path
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();

        // set chromeDrive waits
        driver.manage().timeouts().implicitlyWait(sleepTime, TimeUnit.MICROSECONDS);

        // open the web app
        driver.manage().window().maximize();
        driver.navigate().to(startingPage);
        Thread.sleep(0,loadTime);
    }

    public static void findByXPathAndClickOnElement(String xpath){
        WebElement myWebElement;
        myWebElement = driver.findElement(By.xpath(xpath));
        myWebElement.click();
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
