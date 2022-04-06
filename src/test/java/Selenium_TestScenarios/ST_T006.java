/*
Test Case 6: Verify page redirecting functionality (from Admin Interface to User Interface) in gcrShop application.
Business Rule: It has to redirect from Admin to the User interface, before admin login, and after admin login.

Test Steps:
1. Launch Browser
2. Navigate to the admin interface of the application (https://gcreddy.com/project/admin/login.php)
3. Click the “Online Catalog” link
4. Capture the current URL
5. Back to the previous page
6. Enter valid Username
7.Enter valid Password
8. Click the Login button
9. Capture the current URL
10. Click the “Online Catalog” link
11. Capture the current URL
12. Close Browser window

Verification Points:
1. Verify page redirecting functionality from admin to user interface before login
2. Verify page redirecting functionality from admin to user interface after login

Input / test data:
Username:
Password:

Expected:
1. https://gcreddy.com/project/
2. https://gcreddy.com/project/
 */


package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ST_T006 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://gcreddy.com/project/admin/login.php");

        driver.findElement(By.linkText("Online Catalog")).click();
        Thread.sleep(2000);
        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        if (url1.equals("https://gcreddy.com/project/")) {
        System.out.println("Before Login – Page is redirecting from admin to user interface – Passed");
        }
        else {
        System.out.println("Before Login – Page is Not redirecting from admin to user interface – Failed");
        }

        driver.navigate().back();
        driver.findElement(By.name("username")).sendKeys("gcreddy");
        driver.findElement(By.name("password")).sendKeys("Temp@2020");
        driver.findElement(By.id("tdb1")).click();
        Thread.sleep(2000);

        String url2 = driver.getCurrentUrl();

        if (url2.equals("https://gcreddy.com/project/admin/index.php")) {
            driver.findElement(By.linkText("Online Catalog")).click();
            String url3 = driver.getCurrentUrl();
            System.out.println(url3);

        if (url3.equals("https://gcreddy.com/project/")) {
        System.out.println("After Login – Page is redirecting from admin to user interface – Passed");
        }
        else {
        System.out.println("After Login – Page is Not redirecting from admin to user interface – Failed");
        }
        driver.close();
        }
        }

}
