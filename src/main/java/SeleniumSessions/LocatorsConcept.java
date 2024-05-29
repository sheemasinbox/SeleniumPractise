package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// chrome dev tools:
		// DOM: HTML: Document Object Model
		
		//Approach#1
//		driver.findElement(By.id("input-email")).sendKeys("sheema@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("sheema@123");
		
		
		//Approach#2 - Using WebElement
//		WebElement emailID = driver.findElement(By.id("input-email"));
//		WebElement pwd = driver.findElement(By.id("input-password"));
//		
//		emailID.sendKeys("sheema@gmail.com");
//		pwd.sendKeys("sheema@123");
		
		
		//Approach#3 - Using By locator
//		By emailID = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		WebElement username = driver.findElement(emailID);
//		WebElement password = driver.findElement(pwd);
//		
//		username.sendKeys("sheema@gmail.com");
//		password.sendKeys("sheema@123");
		
		
		//Approach#4 - By locator with some utility
//		By emailID = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		WebElement username = getElement(emailID);
//		WebElement password = getElement(pwd);
//		
//		username.sendKeys("sheema@gmail.com");
//		password.sendKeys("sheema@123");
		
		
		//Approach#5 - By locator with Element util & Action util
//		By emailID = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		doSendKeys(emailID, "sheema@gmail.com");
//		doSendKeys(pwd, "sheema@123");
		
		
		//Approach#6 - By locator and common Utility Class for Elements
//		By emailID = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		//calling functions from the ElementUtil class
//		ElementUtil eutil = new ElementUtil(driver);
//		eutil.doSendKeys(emailID, "sheema@gmail.com");
//		eutil.doSendKeys(pwd, "sheema@123");
		
		
		//Approach#7 - By locators using ElementUtil class and BrowserUtil class -- OpenCartTest.java
		
		//Approach#8 - BY locators using String locators
		String username = "input-email";
		String password = "input-password";
		
		ElementUtil eutil1 = new ElementUtil(driver);
		eutil1.doSendKeys("id", username, "sheema@gmail.com");
		eutil1.doSendKeys("id", password, "sheema@123");
		
		
		
	}
	
	//Methods:
	//Element util
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//Action util
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	//string --> by --> webelement -- action -- 2nd
			//by -- webelement --action -- Ist
			//webelement -- action -- 3rd
	
	///Browser(html/CSS + JS): web pages(JS/TS/React/AngularJS)---> server(Java/GO/PY) -- DB
		//selenium Java ---> Angular JS + GO

}
