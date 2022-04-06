package Selenium_Commands;
//Steps to be done
//1) Right click on Project--> New -->Source Folder-->resources
//2) Place log4j2.properties in resources folder


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lab22_LoggingTest2 {

    public static void main(String[] args) {

        Logger logger=LogManager.getLogger();

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        logger.info("***** Opening URL *****");
        driver.get("https://opensource-demo.orangehrmlive.com/");

        logger.info("***** Login to application *****");

        logger.info("***** Providing username *****");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        logger.info("***** Providing Password *****");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        logger.info("***** Click on Submit *****");
        driver.findElement(By.id("btnLogin")).click();

        logger.info("***** Validating Title after Successfull login *****");
        String title = driver.getTitle();

        if (title.equals("OrangeHRM12"))
        {
            logger.info("*****Login Successfull *****");
            System.out.println("Test Passed...");
        }
        else
        {
            //logger.error("*****Login Unsuccessfull *****");
            logger.debug("*****Login Unsuccessfull *****");
            System.out.println("Test Failed...");
        }
        driver.quit();

    }

}
