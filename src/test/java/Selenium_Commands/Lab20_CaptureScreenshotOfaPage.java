package Selenium_Commands;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab20_CaptureScreenshotOfaPage {

    public static void main(String[] args) throws IOException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mvnrepository.com/");
        driver.manage().window().maximize();



        TakesScreenshot ts=(TakesScreenshot)driver;

        File sr = ts.getScreenshotAs(OutputType.FILE);

        File trg=new File("HomePage_.png");  // You can specify location

        FileUtils.copyFile(sr,trg);
        
        driver.close();

    }

}
