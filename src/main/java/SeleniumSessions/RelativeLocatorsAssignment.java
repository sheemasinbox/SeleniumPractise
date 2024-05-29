package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsAssignment {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Base Element
		WebElement checkBox = driver.findElement(By.cssSelector("input[name='agree']"));
		
		//Check if to the Left of Checkbox we have 'Privacy Policy'
		String text = driver.findElement(with(By.tagName("a")).toLeftOf(checkBox)).getText();
		System.out.println(text);
		
		//Check if to the Right of Checkbox we have 'COntinue' button
		String attrValue = driver.findElement(with(By.cssSelector("input[value='Continue']")).toRightOf(checkBox)).getAttribute("value");
		System.out.println(attrValue);
		
	}

}
