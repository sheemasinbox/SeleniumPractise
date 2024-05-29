package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBasedDropDown {

static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/30-day-free-trial/");

		
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));

		Select select = new Select(country);  //In Select class supply the WebElement of the dropdown
		
		select.selectByIndex(5);
		select.selectByVisibleText("India");
		select.selectByValue("Australia");      //using 'value' attribute
//		select.selectByValue("sheema");     //NoSuchElementException 
//		select.selectByIndex(5000);         //NoSuchElementException
		select.selectByVisibleText(null);   //NPE
		
		
/*		
		By country = By.id("Form_getForm_Country");
		doSelectByIndex(country,5);
		doSelectByValue(country,"Australia");
*/		
	
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByVisibleText(By locator, String visibleText) {
		if(visibleText == null || visibleText.length() == 0) {
			throw new MyElementException("visible text cannot be null");
		}
		
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);;
	}
	
	public static void doSelectByValue(By locator, String value) {
		if(value == null || value.length() == 0) {
			throw new MyElementException("visible text cannot be null");
		}
		
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
