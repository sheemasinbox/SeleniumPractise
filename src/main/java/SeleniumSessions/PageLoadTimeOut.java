package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeOut {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.manage().timeouts().getPageLoadTimeout().getSeconds());
		
		//this only prints whatever time we give in line#14. How to get the actual time taken to load page?
		
		
	}

}
