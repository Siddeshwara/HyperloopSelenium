/*

Test Case 1: Verify Internal and External Links in wikipedia.org

Test Steps:
1. Launch the Browser
2. Navigate to wikipedia.org selenium page
3. Click the “Create account” link
4. Capture the URL
5. Navigate back to Selenium Page
6. Click the “selenium.dev” link
7. Capture the URL
8. Close the Browser

Verification Point/s:
1. Verify if the 1st URL is an Internal link
2. Verify if the 2nd URL is an External link

Input Data/Test Data:
NA

Expected Result/URL:
1. https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29
2. http://www.seleniumhq.org
 */


package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ST_T001 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Selenium_(software)#Selenium_WebDriver");

        driver.findElement(By.xpath("//span[normalize-space()='Create account']")).click();
        String url1=driver.getCurrentUrl();
        System.out.println(url1);

        // url1 = Turgay is good a man
        // url1.contains (man)


        if (url1.contains("Turgay.org")){
            System.out.println("1st Verification: “+ “It is an Internal Link – Passed");
        }
        else{
            System.out.println("1st Verification: “+ “It is Not an Internal Link – Failed");
        }

        driver.navigate().back();
        Thread.sleep(4000);

        driver.findElement(By.partialLinkText("selenium.dev")).click();
        Thread.sleep(4000);

        String url2=driver.getCurrentUrl();
        System.out.println(url2);

        if (url2.contains("seleniu.dev")) {
            System.out.println("2nd Verification: “+ “It is an External Link – Passed");
        }
        else
        {
            System.out.println("2nd Verification: “+ “It is Not an External Link – Failed");
        }
        driver.close();
    }
}



