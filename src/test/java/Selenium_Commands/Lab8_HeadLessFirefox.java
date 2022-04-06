package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Lab8_HeadLessFirefox {

    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup(); //Firefox browser
        //driver = new FirefoxDriver();

        // set Firefox as Headless
        FirefoxOptions opt = new FirefoxOptions();
        opt.setHeadless(false);
        driver=new FirefoxDriver(opt);		//Instantiate Firefox Driver


        driver.get("http://demo.nopcommerce.com/");

        System.out.println("Title of the page:" + driver.getTitle());
        System.out.println("URL of the page:" + driver.getCurrentUrl());


        // Turgay  - class

        // Method A, B , C
        // VAR af, gb, hg

        // Serhat - class
        // Mrthod D E F
        // zt rr gf

        // Serhat obj1 = new Serhat();

        // Obj1.





    }

}
