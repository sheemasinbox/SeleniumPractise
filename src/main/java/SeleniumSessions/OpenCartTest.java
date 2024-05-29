package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	public static void main(String[] args) throws MalformedURLException {
		
		//By locators
		By emailID = By.id("input-email");
		By pwd = By.id("input-password");
		By login = By.className("btn btn-primary");
		
		//Using Browser functions from BrowserUtil class
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.launchURL(new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
		String title = brutil.getPageTitle();
		String url = brutil.getPageURL();
		System.out.println("Page Title is: "+title);
		System.out.println("Current Url is: "+url);
		
		
		//Using WebElement functions from ElementUtil class
		ElementUtil eutil = new ElementUtil(driver);
		eutil.doSendKeys(emailID, "sheema@gmail.com");
		eutil.doSendKeys(pwd, "sheema@123");

	}

}
