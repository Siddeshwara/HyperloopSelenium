package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


public class Lab4_HandleWebElements2 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;
        WebDriverManager.firefoxdriver().setup(); //Firefox browser
        driver = new FirefoxDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement usernametxt=driver.findElement(By.cssSelector("#txtUsername"));
        WebElement passwordtxt=driver.findElement(By.cssSelector("#txtPassword"));

        //isDisplayed(), isEnabled()

        Thread.sleep(4000);

        if(usernametxt.isDisplayed() && usernametxt.isEnabled())
        {
            usernametxt.sendKeys("Admin");
        }
        else
        {
            System.out.println("User name txt element not displayed or not enabled on the page");
        }

        if(passwordtxt.isDisplayed() && passwordtxt.isEnabled())
        {
            passwordtxt.sendKeys("admin123");
        }

        else
        {
            System.out.println("password txt element not displayed or not enabled onthe page");
        }

        driver.findElement(By.cssSelector("#btnLogin")).click();


        System.out.println("Test completed..");

        driver.quit();

    }

}
