package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab14_DoubleClick {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));

        field1.clear(); //clear Field1

        Thread.sleep(3000);
        field1.sendKeys("Welcome to selenium");

        Thread.sleep(4000);

        WebElement button=driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));

        Actions act=new Actions(driver);

        act.doubleClick(button).perform();//double click action

    }

}
