package com.assignment.insure_me_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        //System.out.println( "Hello World!" );
        
        System.out.println("Hello, test case starting.");
        //System.setProperty("webdriver.chrome.driver", "/Users/mainak/Documents/Devops-Bootcamp/Softwares/chromedriver-mac-x64/chromedriver");
    	WebDriverManager.chromedriver().setup();
    	
        ChromeOptions chromeOptions = new ChromeOptions();
        
        chromeOptions.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("http://34.230.28.104:8081/contact.html");
        System.out.println("Hello, test case executing.");
        
        driver.findElement(By.id("inputName")).sendKeys("Mainak");
        driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
        driver.findElement(By.id("inputMail")).sendKeys("mainak@xyz.com");
        driver.findElement(By.id("inputMessage")).sendKeys("Hello");
        Thread.sleep(200);
        
        driver.findElement(By.id("my-button")).click();
        Thread.sleep(200);
        
        if(driver.getPageSource().contains("Message Sent"))
        {
        	System.out.println("Hello, test case successful.");
        }
        else 
        {
        	System.out.println("Hello, test case failed.");
        }
        System.out.println("Hello, test case completed.");
        driver.quit();
    }
}
