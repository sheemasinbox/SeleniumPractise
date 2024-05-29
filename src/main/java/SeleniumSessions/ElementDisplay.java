package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplay {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

/*		boolean flag = driver.findElement((By.className("img-responsive111"))).isDisplayed();   //"responsive111" --- NOSuchElementException
	
		boolean flag = driver.findElement((By.className("img-responsive"))).isDisplayed();
		
		if(flag) {
			System.out.println("logo is displayed");
		}
		else {
			System.out.println("logo not displayed");
		}
			
		By logo = By.className("img-responsive");    //By locator
		
		if(isElementDisplayed(logo)) {
			System.out.println("logo -- Displayed");
		}
*/
		
/*		List<WebElement> logo = driver.findElements(By.className("img-responsive11")); //returns Empty ArrayList as classname is wrong
		
		if (logo.size() == 1) {
			System.out.println("logo is displayed");
		}
		else {
			System.out.println("logo is not displayed");
		}
*/
		
		By logo = By.className("img-responsive");
		if(isElementExist(logo)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
	}
	
	//Methods
	public static boolean isElementExist(By locator) {
		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
