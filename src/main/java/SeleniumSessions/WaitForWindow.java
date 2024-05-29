package SeleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //parent
		
		driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			
			String parentWindowId = it.next();
			System.out.println("parent window id : " +parentWindowId);
			
			String childWindowId = it.next();
			System.out.println("child window Id : " +childWindowId);
		}
		
	}

}
