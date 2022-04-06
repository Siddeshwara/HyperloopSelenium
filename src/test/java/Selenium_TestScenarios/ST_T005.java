/*
Test Case 5: Verify Customer Login in gcrShop Application User Interface.
Test Steps:
1. Launch Browser
2. Navigate to gcrShop User Interface Login Page (https://gcreddy.com/project/login.php)
3. Enter E-Mail Address
4. Enter Password
5. Click “Sign In” Button

Input Data/Test Data:
E-mail Address: meghala1234S@gmail.com
Password: xyz4321

Verification Point:
Verify the Existence of the “Log Off” Link…
 */

package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ST_T005 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://gcreddy.com/project/login.php");

        driver.findElement(By.name("email_address")).sendKeys("sriniram123@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abcd321");
        driver.findElement(By.id("tdb1")).click();
        Thread.sleep(2000);

        try {
            boolean elementExistence = driver.findElement(By.linkText("Log Off")).isDisplayed();

            if (elementExistence) {
                System.out.println("Customer Login is Successful – Passed");
            }
        } catch (NoSuchElementException e1) {
            System.out.println("Customer Login is Unsuccessful – Failed");
        }
        driver.close();
    }
}