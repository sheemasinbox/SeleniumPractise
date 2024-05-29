package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		driver.findElement(By.id("APjFqb")).sendKeys("How to take snapshot in Lenovo TP");
		driver.findElement(By.id("APjFqb")).click();
		
//		driver.close();
	}

}
