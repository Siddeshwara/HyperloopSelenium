package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class ST_T007 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gcreddy.com/discussiongroup/ucp.php?mode=register");

        driver.findElement(By.id("agreed")).click();

        driver.findElement(By.id("username")).sendKeys("Indianewad");

        String Email = "Indianew"+Math.random()+"@gmail.com";
        driver.findElement(By.id("email")).sendKeys(Email);

        driver.findElement(By.id("new_password")).sendKeys("Abcd123");
        driver.findElement(By.id("password_confirm")).sendKeys("Abcd123");

        System.out.println("Enter Verification Code");
        Scanner scan = new Scanner(System.in);
        String captcha = scan.nextLine();

        driver.findElement(By.id("confirm_code")).sendKeys(captcha);

        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        String message = driver.findElement(By.xpath("//*[@id=\"message\"]/div/p")).getText();

        if (message.contains("Your account has been created.")) {
            System.out.println("User Registration is Successful – Passed");
        }
        else {
            System.out.println("User Registration is Unsuccessful – Failed");
        }
        driver.close();
}
}
