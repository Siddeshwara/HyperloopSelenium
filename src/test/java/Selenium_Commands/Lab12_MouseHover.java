package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Lab12_MouseHover {

    public static void main(String[] args)throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Navigate to site
        driver.get("https://www.actitime.com/");
        WebElement features = driver.findElement(By.xpath("//span[normalize-space()='Features']"));

        // Create Object of Action Class
        Actions act = new Actions(driver);

        // Move to element for which you want mouse hover

        // act.moveToElement(features).perform();   //Single statement without using Action class object


        Action action= act.moveToElement(features).build();
        action.perform();

        Thread.sleep(6000);

        // Click on link
        driver.findElement(By.xpath("//span[normalize-space()='Resources']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
