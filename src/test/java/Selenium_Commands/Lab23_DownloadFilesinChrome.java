package Selenium_Commands;

import java.io.File;
import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab23_DownloadFilesinChrome {

    public static void main(String[] args) throws InterruptedException {

        //Script for downloading files in desired location
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory","C:\\Downloads");

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        //-----------------------------------------


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();



        driver.get("http://demo.automationtesting.in/FileDownload.html");
        driver.manage().window().maximize();

        //Downloading Text File
        driver.findElement(By.id("textbox")).sendKeys("Welcome"); //text box
        driver.findElement(By.xpath("//button[@id='createTxt']")).click();  // Generate file button
        driver.findElement(By.xpath("//a[@type='button']")).click(); //download link
        Thread.sleep(3000);

        boolean status=isFileExist("C:\\Downloads\\info.txt");
        if(status==true)
        {
            System.out.println("Text File Exists");
        }
        else
        {
            System.out.println("Text File Not Exists");
        }


        //Downloading PDF File
        driver.findElement(By.id("pdfbox")).sendKeys("welcome");
        driver.findElement(By.id("createPdf")).click();
        driver.findElement(By.id("pdf-link-to-download")).click();
        Thread.sleep(3000);

        status=isFileExist("C:\\Downloads\\info.pdf");
        if(status==true)
        {
            System.out.println("PDF File Exists");
        }
        else
        {
            System.out.println("PDF File Not Exists");
        }

    }



    public static boolean isFileExist(String loc)
    {
        File f=new File(loc);
        if(f.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
