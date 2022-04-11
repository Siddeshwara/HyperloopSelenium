package TestNG;

import org.testng.annotations.Test;

/*TestCase:
---------------------
1) Launch browser
2) Open URL
3) Login to application
4) Logout from application
*/

public class MyFirstTestCase {

	@Test
	void asetup()
	{
	System.out.println("Launching browser........");
	System.out.println("Opening URL........");
	}
	
	@Test
	void login()
	{
		//Login steps
		System.out.println("Login test");
	}
	
	@Test
	void logout()
	{
		//steps for logout
		System.out.println("Logout from app");
	}
	
}
