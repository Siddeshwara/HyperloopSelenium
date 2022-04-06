package Selenium_Commands;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*1) How many rows in  table
2) How many columns in a table
3) Retrieve the specific row/column data
4) Retrieve all the data from the table
5) Print book names whose author is Mukesh(Conditional based retrieval of rows)
6) Find sum of cost of all books listed
 *
 */

public class Lab17_WebTable1 {

    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        //	1) How many rows in  table
        int rows=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
        //int rows = driver.findElements(By.tagName("tr")).size();
        System.out.println("Number of rows in  a table:"+rows);//7

        // 2) How many columns in a table
        int cols=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th")).size();
        System.out.println("Number of columns in  a table:"+cols);//4

        //3) Retrieve the specific row/column data
        //String value=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[5]/td[1]")).getText();
        //System.out.println(value);

        //4) Retrieve all the data from the table

		/*for(int r=2;r<=rows;r++) //2 3 4.....7
		{
			for(int c=1;c<=cols;c++)  //1..4
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"     ");   //r= 2  c=1    //r=2  c=2  //r=3 c=1
			}
			System.out.println();
		}*/

        //5) Print book names whose author is Mukesh

		/*for(int r=2;r<=rows;r++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[2]")).getText();

			if(authorName.equals("Mukesh"))
			{
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[1]")).getText();
				String price=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[4]")).getText();
				System.out.println(bookName+"    "+authorName+"    "+price);
			}
		}*/

        //6) Find sum of cost of all books listed

        int sum_price = 0;
        for(int r=2;r<=rows;r++)
        {
            String price=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[4]")).getText();
            sum_price=sum_price+Integer.parseInt(price);
        }
        System.out.println("total price: " + sum_price);

        driver.quit();

    }

}

