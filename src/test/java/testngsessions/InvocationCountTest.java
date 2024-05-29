package testngsessions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocationCountTest {

	//invocationCount = executionCount -- gets executed a number of times
	//no specific UC in Sel
	//maybe in API we can create a number of users by using this invocationCOunt
	//invocationCount, priority, etc are only for @Test; not for @BeforeTest or @AfterTest
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT -- create user");
	}
	
	@Test(invocationCount  = 10, priority = 2)
	public void createUserTest() {
		System.out.println("createUserTest");
	}
	
	@Test(priority  = 1)
	public void paymentTest() {
		System.out.println("paymentTest");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- deleteUser");
	}
	
}
