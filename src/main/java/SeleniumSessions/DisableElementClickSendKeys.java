package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableElementClickSendKeys {
static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		

		driver.findElement(By.id("pass")).click();       //if element is disabled -- then no exception
//		driver.findElement(By.id("pass")).sendKeys("testing");   //ElementNotInteractableException  -- element not interactable
		
//		driver.findElement(By.id("fname")).sendKeys(null);  //IllegalArgumentException -- Keys to send should be a not null CharSequence
//		driver.findElement(By.id("fname")).sendKeys("null");   //here "null" is a string, so it will enter
//		
		StringBuilder sb = new StringBuilder("testing");
		String s = "automation";
		StringBuffer sbu =  new StringBuffer("Done");
//		driver.findElement(By.id("fname")).sendKeys(s);
		driver.findElement(By.id("fname")).sendKeys(sb + s + sbu);
//		driver.findElement(By.id("fname")).sendKeys(sb , s , "sheema");  //Array of values
		
		//CharSequence -- interface
		//String, StringBuilder, StringBuffer
		
		
		
		
		
	}

}
