package TestNG;

import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test(priority=1)
	void tm3()
	{
		System.out.println("This is TM3 from TC2");
	}
	
	@Test(priority=2)
	void tm4()
	{
		System.out.println("This is TM4 from TC2");
	}
}
