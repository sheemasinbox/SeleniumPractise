package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementException {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		//If elements are not available for findElement and findElements
		
//		driver.findElement(By.name("search11")).sendKeys("MacBook");           //NoSuchElementException -- Unable to locate Element
		
		List<WebElement> elements = driver.findElements(By.tagName("sheema"));
		System.out.println(elements);               //empty arraylist - []
		System.out.println(elements.size());        //size = 0
	}

}
