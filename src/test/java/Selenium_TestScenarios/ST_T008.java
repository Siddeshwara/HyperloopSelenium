/*
Test Case 8: Data-Driven Testing for “Admin Login” functionality by reading test data from a text file.
        What is Data-Driven Testing?
        Data-driven testing is the creation of test scripts where test data and/or output values are read from data files instead of using the hard-coded values each time the test runs.

        Why Data-Driven Testing?
        For conducting Positive and Negative Testing

        Difference between Parameterization and Data-Driven Testing?
        For passing a single value or multiple values we use Parameterization, we use multiple values only for Data-driven testing.

        How to conduct Data-Driven Testing?
        By using any resource (Test Data file) we can conduct Data-driven testing.

        Steps for Data-Driven Testing:
        1. Read Test Data from an external file
        2. Create a Test case
        3. Connect Test data with the Test case

 */
package Selenium_TestScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ST_T008 {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        FileReader fileObject = new FileReader("C:\\SeleniumTraining\\input.txt");
        BufferedReader br = new BufferedReader(fileObject);
        String line;
        int lineCount = 0;
        int Iteration = 0;

        while ((line = br.readLine()) != null) {
            String[] inputData = line.split(", ", 2);
            lineCount = lineCount + 1;

            if (lineCount > 1) {
                Iteration = Iteration + 1;

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://gcreddy.com/project/admin/login.php");
                driver.findElement(By.name("username")).sendKeys(inputData[0]);
                driver.findElement(By.name("password")).sendKeys(inputData[1]);
                driver.findElement(By.id("tdb1")).click();
                Thread.sleep(2000);

                String url = driver.getCurrentUrl();

                if (url.equals("https://gcreddy.com/project/admin/index.php")) {
                    System.out.println(Iteration + " Admin Login is Successful – Passed");
                } else {
                    System.out.println(Iteration + " Admin Login is Unsuccessful – Failed");
                }
                driver.close();
            }
            br.close();
            fileObject.close();
        }
    }
}


