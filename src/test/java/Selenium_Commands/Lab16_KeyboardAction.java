package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab16_KeyboardAction {

    public static void main(String[] args){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/key_presses");

        //option1:
        //driver.findElement(By.id("content")).sendKeys(Keys.SPACE);

        Actions action = new Actions(driver);

        action.sendKeys(Keys.CANCEL).build().perform();//Keys.ESCAPE, Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.BACK_SPACE


        String text = driver.findElement(By.id("result")).getText();
        System.out.println(text);

        if(text.contains("You entered: CANCEL"))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test Failed");
        }

        driver.close();

    }

}