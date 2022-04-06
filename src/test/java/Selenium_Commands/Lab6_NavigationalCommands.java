package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab6_NavigationalCommands {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com");
        System.out.println(driver.getCurrentUrl());


        driver.navigate().to("http://www.amazon.com");
        System.out.println(driver.getCurrentUrl());

        //back and forward buttons simulation:
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(3000);

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(3000);

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();

        driver.quit();

    }

}
