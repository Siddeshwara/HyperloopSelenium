package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab15_DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        Actions act=new Actions(driver);

        WebElement italy=driver.findElement(By.id("box6"));
        WebElement rome=driver.findElement(By.id("box106"));


        act.dragAndDrop(italy, rome).perform(); //drag and drop
        Thread.sleep(3000);

        WebElement unitedstates=driver.findElement(By.id("box103"));
        WebElement washington=driver.findElement(By.id("box3"));


        act.dragAndDrop(washington,unitedstates).perform(); //drag and drop
        Thread.sleep(3000);

        driver.close();
    }

}




