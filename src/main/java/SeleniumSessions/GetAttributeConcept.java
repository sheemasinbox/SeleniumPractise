package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// text --> getText()
		// attribute --> getAttribute()

		// get all the links
		// capture href value

		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		String placeholder = driver.findElement(fname).getAttribute("placeholder");
//		String name = driver.findElement(fname).getAttribute("name");
//		String type = driver.findElement(fname).getAttribute("type");

		// By Locators
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By registerLink = By.linkText("Register");

		String placeholder = doElementGetAttribute(fname, "placeholder");
		String name = doElementGetAttribute(fname, "name");
		String type = doElementGetAttribute(fname, "type");
		System.out.println("placeholder: " + placeholder + " , name: " + name + " , type: " + type);
		
		String register = doElementGetAttribute(registerLink, "href");
		System.out.println("Register href: " +register);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		// get href values of Elements
		List<WebElement> href_links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + href_links.size());

		for (WebElement e : href_links) {
			String linkText = e.getText();
			String href_link = e.getAttribute("href");
			System.out.println(linkText + " -- " + href_link);
		}

	}

	//Methods
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String doElementGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

}
