package Selenium_Commands;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class Lab13_RightClick {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        Actions act = new Actions(driver);


        WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));


        act.contextClick(button).perform(); // Right click on the button
        Thread.sleep(3000);

        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']"
                        + "/li[contains(@class,'context-menu-icon')]"));


        System.out.println(optionsList.size());

//		for(int i=0; i<optionsList.size(); i++){
//			String text = optionsList.get(i).getText();
//			System.out.println(text);
//				if(text.equals("Copy")){
//					optionsList.get(i).click();
//					break;
//				}
//		}

        //OR

        driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click(); // copy

        Thread.sleep(3000);

        System.out.println(driver.switchTo().alert().getText()); // capturing the text present on alert box
        Thread.sleep(3000);

        driver.switchTo().alert().accept(); // close alert box

        driver.close();
    }
}
