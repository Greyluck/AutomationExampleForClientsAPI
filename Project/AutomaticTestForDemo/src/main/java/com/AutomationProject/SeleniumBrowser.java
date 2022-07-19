package com.AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class SeleniumBrowser {

    public static WebDriver driver = null;

    public static void main(String[] args){
        System.out.println("Executing Basic Browser");
    };

    public static boolean returnWebTestResult() throws InterruptedException {
        return SeleniumBrowser.executeSimpleUITest();
    }

    public static boolean executeSimpleUITest() throws InterruptedException {

        //@TODO: This is hardcoded to make a quick web test, it should be improved later
        //----------------------------------------------------------------------
        // Basic settings
        String webPageToBeTested = "https://asimplewebpage.netlify.app/";

        // Page 1
        String[] dataToComplete = {"Emilio","Ontiveros", "30","6/11/1991'"};
        String[] fieldsToComplete = {"fname","lname","age","dob"};
        // Page 2
        String[] dataToComplete2 = {"Maipu","851 3C","Buenos Aires","Argentina"};
        String[] fieldsToComplete2 = {"street1","street2","state","country"};
        //----------------------------------------------------------------------

        // set chromeDriver path
        System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        int sleepTime = 500;
        int loadTime = 1500;

        // open the web app
        driver.navigate().to(webPageToBeTested);
        driver.manage().window().maximize();

        // Page 1
        Thread.sleep(loadTime);
        WebElement myWebElement;
        for (int i=0;i<fieldsToComplete.length;i++) {
            myWebElement = driver.findElement(By.xpath("//*[@id=\""+fieldsToComplete[i]+"\"]"));
            myWebElement.sendKeys(dataToComplete[i]);
            Thread.sleep(sleepTime);
        }
        myWebElement = driver.findElement(By.xpath("//*[@type=\"submit\" and @value=\"Next\"]"));
        myWebElement.click();

        // Page 2
        for (int i=0;i<fieldsToComplete2.length;i++) {
            myWebElement = driver.findElement(By.xpath("//*[@id=\""+fieldsToComplete2[i]+"\"]"));
            myWebElement.sendKeys(dataToComplete2[i]);
            Thread.sleep(sleepTime);
        }
        myWebElement = driver.findElement(By.xpath("//*[@type=\"submit\" and @value=\"Submit\"]"));
        myWebElement.click();

        // Page 3
        Thread.sleep(loadTime);
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Success!')]"));
            System.out.println("Test case completed successfully");
        } catch (NoSuchElementException e) {
            System.out.println("Test case completed with errors");
        }
        driver.close();
        driver.quit();
        return true;
    }
}
