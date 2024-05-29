package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {

	//Default priority = 0
	// negative -- 0 -- 1 -- etc
	//Duplicate priority -- priority does not make sense, so follows alphabetical order
	//some @test with priority and some @test non-priority -- 1st non-priority(0 priority) in alphabetical order and then priority tests
	//not recommended to use negative/duplicate
	
	@Test (priority = 0)  
	public void eTest() {
		System.out.println("e test");
	}
	
	@Test  (priority = 5) 
	public void dTest() {
		System.out.println("d test");
	}
	
	@Test  (priority = -1) 
	public void cTest() {
		System.out.println("c test");
	}
	
	@Test   (priority = 3)
	public void aTest() {
		System.out.println("a test");
	}
	
	@Test   (priority = 4)
	public void bTest() {
		System.out.println("b test");
	}
	
}
