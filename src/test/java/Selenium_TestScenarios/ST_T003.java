/*

Test Case 3: Verify Admin Login Functionality in gcrShop application Admin Interface
Test Steps:
1. Launch Browser
2. Navigate / launch /load login page of admin interface of the gcrShop application (https://gcreddy.com/project/admin/login.php)
3. Enter valid “Username”
4. Enter valid “Password”
5. Click on “Login” Button
6. Capture the current URL
7. Close the Browser window

Verification Point
Compare the captured URL with Expected

Input / Test Data:
Username = gcreddy
Password = Temp@2020

Expected Result:
https://gcreddy.com/project/admin/index.php

Actual Result: * After Test Case Execution

Test Result: pass/fail (* After Test Case Execution)

Comments: * After Test Case Execution
 */


package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ST_T003 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://gcreddy.com/project/admin/login.php");

        driver.findElement(By.name("username")).sendKeys("gcreddy");
        driver.findElement(By.name("password")).sendKeys("Temp@2020");
        driver.findElement(By.id("tdb1")).click();
        Thread.sleep(2000);

        try {
            boolean linkExists = driver.findElement(By.linkText("Logoff")).isDisplayed();

            if (linkExists) {
                System.out.println("Admin Login is Successful – Passed");
            }
        }
        catch (NoSuchElementException e1) {
            System.out.println("Admin Login is Unsuccessful – Failed");
        }
        driver.close();
}
}
