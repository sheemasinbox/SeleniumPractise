package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		//Wait(I) : until(); --> FluentWait(C): (@overridden)until(){} + other methods --> WebDriverWait (C): no methods
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		//By Locators:
		By fullName = By.id("Form_getForm_Name");
		By BussEmail = By.id("Form_getForm_Email");
		By phone = By.id("Form_getForm_Contact");
		
		waitForElementPresence(fullName, 10).sendKeys("testing");    //wait:10secs
		getElement(BussEmail).sendKeys("testing@gmail.com");         //No wait
		waitForElementVisible(phone, 10).sendKeys("8769076434");     //wait:10secs                      //wait:10secs
		
/*
		//e1: 10secs
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fullName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(fullName));
		fullName_ele.sendKeys("testing");
		
		//e2: 0secs
		driver.findElement(BussEmail).sendKeys("testing@gmail.com");
*/		
		
		
		

	}
	
	//Methods:
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
