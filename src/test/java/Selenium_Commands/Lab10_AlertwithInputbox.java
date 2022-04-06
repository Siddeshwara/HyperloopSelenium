package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab10_AlertwithInputbox {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();//button1

        driver.findElement(By.xpath("//*[@id='Textbox']/button")).click(); //button2

        Thread.sleep(5000);

        driver.switchTo().alert().sendKeys("Starkkraft");

        Thread.sleep(5000);

        driver.switchTo().alert().accept();

        System.out.println("Test completed");

        driver.close();



    }

}
