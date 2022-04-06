package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab9_Alerts {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();

        Thread.sleep(5000);

        //driver.switchTo().alert().dismiss();

        Alert alertbox = driver.switchTo().alert();

        System.out.println(alertbox.getText());

        alertbox.dismiss();  // closes alert window by using OK button

        Thread.sleep(4000);
        //alertbox.dismiss(); //close alert window by using cancel button

        driver.close();

    }

}
