package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab2_GetCommands {

    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().window().maximize(); // Maximize browser window

        System.out.println("Title of the page:" + driver.getTitle());
        System.out.println("URL Of the page:" + driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();

    }

}
