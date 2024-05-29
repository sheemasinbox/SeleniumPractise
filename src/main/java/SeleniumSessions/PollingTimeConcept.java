package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingTimeConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //parent
		
		By twitter = By.xpath("//a[contains(@href, 'twitter')]");
		
//		Polling Time is interval time or sleep time. Interval at which the server hits the application for the element.
//		Default polling time= 500ms
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration timeOut, Duration sleep)
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2)); //polling time=2secs
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(twitter)).click();

	}

}
