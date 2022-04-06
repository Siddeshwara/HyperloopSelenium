package Selenium_Commands;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lab11_ImplicitWait {

    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup(); //Firefox browser
        driver = new FirefoxDriver();

        driver.get("https://www.Amazon.com/");
        driver.manage().window().maximize();

        // dynamic wait
        //By default it is set to 0
        //Implicit wait is applicable for the entire session of browser

        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//img[@alt='Bronson Selenium 200 mcg for Immune System and Antioxidant Support – Essential Trace Mineral, Non-GMO, 250 Vegetarian Tablets']")).click();

        driver.quit();
    }

}
