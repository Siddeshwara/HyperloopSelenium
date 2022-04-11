package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NopCommerceLogin {

	WebDriver driver;

	@Test(priority=1)
	public void OpenBrowser()
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/");
	}
	
	@Test(priority=2)
	public void getInfo() throws InterruptedException
	{
		System.out.println("Title of the page:" + driver.getTitle());
		System.out.println("URL Of the page:" + driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
	}
	
	@Test(priority=3)
	public void CloseBrowser()

	{
		driver.close();
	}
	
	
}





