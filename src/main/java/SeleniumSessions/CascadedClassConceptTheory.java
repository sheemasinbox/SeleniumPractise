package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CascadedClassConceptTheory {
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
//		//InvalidSelectorException: Compound class names not permitted
//		//Invalid
//		driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("sheema@gmail.com");
//
//		//InValid
//		//NoSuchElementException: no such element: Unable to locate element
//		driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.xpath("//input[contains(@class,'login-email')]")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.className("login-email")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.cssSelector("input.login-email")).sendKeys("sheema@gmail.com");
//		
//		//Valid
//		driver.findElement(By.cssSelector("input.form-control.login-email")).sendKeys("sheema@gmail.com");
		
		//Valid:
		driver.findElement(By.cssSelector("input.form-control.private-form_control.login-email")).sendKeys("sheema@gmail.com");
		
		//Valid:
		driver.findElement(By.cssSelector("input[class = 'form-control private-form_control login-email']")).sendKeys("sheema@gmail.com");
		
		//InvalidSelectorException: invalid selector. The string '//input[@#@#@#@id='username']' is not a valid XPath expression.
		driver.findElement(By.xpath("//input[@#@#@#@id='username']")).sendKeys("sheema@gmail.com");
		
		
		
	}

}
