package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoading {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		boolean flag = isPageLoaded(10);
		if(!flag) {
			throw new BrowserException("Page is not loaded");
		}
		
		
	}
	
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'")).toString();
		return Boolean.parseBoolean(flag);
		
		
	}

}
