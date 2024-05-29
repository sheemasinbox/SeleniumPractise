package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class LaunchChrome1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		String title = driver.getTitle();
		String currentURL = driver.getCurrentUrl();
		System.out.println("Title is: " +title);
		System.out.println("Current url is: "+currentURL);
		String pageSource = driver.getPageSource();
//		System.out.println("Page SOurce is: " +pageSource);
		
		driver = new ChromeDriver();
		driver.get("https://google.com/");
		String title1 = driver.getTitle();
		String currentURL1 = driver.getCurrentUrl();
		System.out.println("Title is: " +title1);
		System.out.println("Current url is: "+currentURL1);
		
		
		//Both driver.close() and driver.quit() methods close only the last opened browser, 
		//if 2 different browsers are launched using the WD d = new CD();
		driver.close();    
		
//		driver.quit();
		
	
	}

}
