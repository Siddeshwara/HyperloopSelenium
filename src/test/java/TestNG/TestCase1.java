package TestNG;

import org.testng.annotations.*;

public class TestCase1 {

	@BeforeTest
	void BeforeTest()
	{
		System.out.println("BeforeTest");
	}

	@BeforeClass
	void BeforeClass()
	{
		System.out.println("BeforeClass");
	}

	@AfterClass
	void AfterClass()
	{
		System.out.println("AfterClass");
	}

	
	@Test(enabled=true)
	void aTest1()
	{
		System.out.println("Test1");
	}

	@Test
	void aTest2()
	{
		System.out.println("Test2");
	}

	@AfterTest
	void AfterTest()
	{
		System.out.println("After Test");

	}

}
