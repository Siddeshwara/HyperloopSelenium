 /***** Handling WebElements ****
 * Input box
 * Radio buttons
 * Check boxes

 **** Conditional Commands
 isDisplayed()
 isEnabled()
 isSelected()

 */

 package Selenium_Commands;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab3_HandleWebElements1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Register.html");

        driver.manage().window().maximize(); // Maximize browser window

        WebElement firstname = driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));


        firstname.isDisplayed();
        firstname.isEnabled();
        firstname.sendKeys("Serhat");

        // ************* Input box/Text box ***********************
        System.out.println("Display status of FirstName:" + firstname.isDisplayed());
        System.out.println("Enable status of FirstName:" + firstname.isEnabled());
        firstname.sendKeys("David");

        // firstname.clear();

        driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]")).sendKeys("John");

        // ************* Radio buttons ***********************

        WebElement radiobutton = driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/label[1]/input[1]")); // Male


        System.out.println("Display status of Male radio button:" + radiobutton.isDisplayed()); // true
        System.out.println("Enable status of Male radio button:" + radiobutton.isEnabled()); // true
        System.out.println("Selected status of Male radio button:" + radiobutton.isSelected()); // false

        // selecting female radio button

        driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/label[2]/input[1]")).click(); // select Female radio button

        System.out.println("Selected status of Male radio button:" + radiobutton.isSelected()); // false

        // ************* Check boxes ***********************

        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox2"));

        System.out.println("Display status of Movies checkbox:" + checkbox.isDisplayed()); // true
        System.out.println("Enable status of Movies checkbox:" + checkbox.isEnabled()); // true
        System.out.println("Selected status of Movies checkbox:" + checkbox.isSelected()); // false

        checkbox.click(); // select Movies check box
        Thread.sleep(4000);

        System.out.println("Selected status of Movies checkbox:" + checkbox.isSelected()); // true

        driver.findElement(By.cssSelector("#checkbox1")).click(); // Cricket
        driver.findElement(By.cssSelector("#checkbox3")).click(); // Hockey

        System.out.println("Test completed..");

        driver.close();

    }

}
