package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		driver.manage().window().maximize();
		
//		String title = waitForTitleContains("Advanced Free Trial",5);
//		System.out.println(title);
		
		String title = waitForTitleIs("30-Day Advanced Free Trial | OrangeHRM",5);
		System.out.println(title);
		
		driver.findElement(By.linkText("Book a Free Demo")).click();
	
//		String url = waitForUrlContains("/book-a-free-demo/", 5);
//		System.out.println(url);
		
		String url = waitForUrlIs("https://www.orangehrm.com/en/book-a-free-demo/", 5);
		System.out.println(url);
		
		
	}
	
	//methods:
	public static String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(titleFraction));
			return driver.getTitle();
		}
		catch(Exception e) {
			System.out.println("title is not found within: "+timeOut);
		}
		return null;
	}
	
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		}
		catch(Exception e) {
			System.out.println("title is not found within: "+timeOut);
		}
		return null;
	}
	
	public static String waitForUrlContains(String UrlFraction, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(UrlFraction));
			return driver.getCurrentUrl();
		}
		catch(Exception e) {
			System.out.println("url is not found within: "+timeOut);
		}
		return null;
	}
	
	public static String waitForUrlIs(String Url, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlToBe(Url));
			return driver.getCurrentUrl();
		}
		catch(Exception e) {
			System.out.println("url is not found within: "+timeOut);
		}
		return null;
	}

}
