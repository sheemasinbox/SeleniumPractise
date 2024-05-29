package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleTest extends BaseTest {

//Approach#1 -- slow but better to use @BM as it has more pass percentage guarantee. 	
//Say, if application/browser crashes during execution(TC#3), then all the remaining TC's continue execution. SO the Pass percentage is high(Pass% - 97%).
	
	@Test (priority = 1)  
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google","Title is not matched");
	}
	
	
	@Test(priority = 3) 
	public void imageTest() {
		boolean flag = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	//	Assert.assertEquals(flag, true);
		Assert.assertTrue(flag);
	}
	
	
	@Test (priority = 2) 
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("google"));
	}
	
	
	/* //Approach#2 -- faster but better to use for simple sanity TC's. Say, if application/browser crashes during execution(TC#3), then all the remaining TC's fail(97 TC's fail). SO the Pass percentage might be low(Pass% - 3% only).
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test   
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	
	@Test
	public void imageTest() {
		driver.findElement(By.xpath("//img[@alt='Google]")).isDisplayed();
		
	}
	
	
	@Test
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	*/
	
	
}
