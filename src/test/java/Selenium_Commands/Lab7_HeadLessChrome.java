package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab7_HeadLessChrome {

    public static void main(String[] args) {

        WebDriver driver;
        ChromeOptions options;
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        // set chrome as Headless
        options = new ChromeOptions();
        options.setHeadless(true); 	//options.addArguments("--headless");
        driver = new ChromeDriver(options);		//Instantiate Chrome Driver


        driver.get("http://demo.nopcommerce.com/");

        System.out.println("Title of the page:" + driver.getTitle());
        System.out.println("URL of the page:" + driver.getCurrentUrl());

    }

}
