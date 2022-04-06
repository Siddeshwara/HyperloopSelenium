/*Browser commands
 * Close & quite
 *
 */

package Selenium_Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab5_BrowserCommands {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();  // maximize

        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

        Thread.sleep(3000);

        //driver.close(); // closes only current browser ( single)

        driver.quit(); // closes all the browsers.

    }

}
