package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
1) Open Web Browser(Chrome/firefox/IE).
2) Open URL  https://opensource-demo.orangehrmlive.com/
3) Enter username  (Admin).
4) Enter password  (admin123).
5) Click on Login.
6) Capture title of the home page.(Actual title)
7) Verify title of the page: OrangeHRM    (Expected)
8) close browser

 */

public class Lab1_FirstTestCase {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        //1) Open Web Browser
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();  //ChromeDriver driver=new ChromeDriver();

		//Firefox
		//System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();

        //IE
        //System.setProperty("webdriver.ie.driver","C:\\Drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
        //WebDriver driver=new InternetExplorerDriver();

        WebDriverManager.chromedriver().setup(); //Chrome
        driver = new ChromeDriver();

        /*
        WebDriverManager.firefoxdriver().setup(); //Firefox
        driver = new FirefoxDriver();

        WebDriverManager.edgedriver().setup(); //Edge Driver
        driver = new EdgeDriver();

        WebDriverManager.iedriver().setup(); //IE Driver
        driver = new InternetExplorerDriver();
        */

        //2) Open URL  https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //3) Enter username  (Admin).
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //4) Enter password  (admin123).
        driver.findElement(By.id("txtPassword")).sendKeys("aadsf");

        Thread.sleep(5000);
        //5) Click on Login.
        driver.findElement(By.id("btnLogin")).click();

        //6) Capture title of the home page.(Actual title)

        String act_title=driver.getTitle();

        System.out.println(act_title);
        String exp_title="OrangeHRM";

        //7) Verify title of the page: OrangeHRM    (Expected)

        Thread.sleep(10000);

        if(act_title.equals(exp_title))
        {
            System.out.println("Test passed.....");
        }
        else
        {
            System.out.println("Test failed.....");
        }

        //8) close browser
        driver.close();


    }

}
