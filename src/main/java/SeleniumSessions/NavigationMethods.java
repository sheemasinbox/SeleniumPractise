package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws MalformedURLException {
		
		//back and forward navigation
		//get vs to
		//refresh
		//Navigation methods - back, forward, to, refresh (4 methods)
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(new URL("https://www.google.com")); //creating object of URL class
	//	driver.navigate().to("https://google.com/");
		
		
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		
//		driver.navigate().to("https://google.com/");
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());

		
		//refresh page
		driver.navigate().refresh();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
