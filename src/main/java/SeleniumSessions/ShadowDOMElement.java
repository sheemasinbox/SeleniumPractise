package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElement {

	public static void main(String[] args) {
		
		//In Chrome browser, enter "chrome://settings/", go to 'Search Settings' field and try to sendKeys
		
		WebDriver driver = new ChromeDriver();
		driver.get("chrome://settings/");
		
/*		driver.findElement(By.id("searchInput")).sendKeys("notification"); //throws error NoSuchElementFoundException
		
		// #shadow-root (open) is attached with this particular field.
		// IT is a very light-weight container on the webpage.
		// Like iFrame, shadow-root is also used for security purposes -- to prevent data sniffing.
		// shadow-root is more secure as coming inside a shadoW-root is more difficult.
		// shadow-root should be in 'open' state to be able to automate.
		// No direct method in Sel, use JS
		// goto the element in DOM, right-click, click on copy JS path and paste it in console and enter.
		// you will get the HTML element (not WebElement -- WebElement is for Sel)
		// you must cast this HTML element as a WebElement
		 * 
		//Selenium is not a good choice if application is full of shadow DOM. Playwright or WebDriverIO is a better choice as they have better compatibility.
*/
		String search_script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\");";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement search  = (WebElement)js.executeScript(search_script);    //casting HTML element as a WebElement
		
		search.sendKeys("notifications");
		
		
		

	}

}
