/*
Test Case 2: Verify “Sell” Link existence in Google Home page.
        Test Steps:
        1. Launch the Browser
        2. Navigate to Google Home page (“https://www.Amazon.com”)
        3. Return the “Sell” displayed status

        Verification Point/s:
        Verify the existence of “Sell” Link

        Input Data:
        NA

 */

package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ST_T002 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");



            boolean linkExistence=driver.findElement(By.linkText("Sell")).isDisplayed();

            if (linkExistence == true) {
                System.out.println("Sell Link Exists – Passed");
            }
            else
            {
                System.out.println("Sell Link Not Exists – Failed");

            }
        driver.close();
        }

}

