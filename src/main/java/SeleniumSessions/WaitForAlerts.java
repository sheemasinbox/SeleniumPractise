package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlerts {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//alerts
		//prompt
		//confirm
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
//		driver.switchTo().alert();    -- but at times the alert may take time to appear, so apply wait
		
		String alertText = getAlertText(5);
		System.out.println(alertText);
		acceptAlert(5);
		

	}
	
	//Methods:
	
	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}
	
	public static void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}
	
	public static void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}
	
	
	
}
