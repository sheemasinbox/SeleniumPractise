package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldValue {
static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//Fetch Values entered in  a Text Field
		driver.findElement(By.id("input-email")).sendKeys("sheema@gmail.com");
//X		String email = driver.findElement(By.id("input-email")).getText();
//X		System.out.println(email);

		//value attribute will hold the values entered in text fields
		String email = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println(email);
	}

}
