package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMultiLevelMenuHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(
				"https://bigbasket.com/");

		By level1Menu = By.xpath("(//span[contains(text(),'Shop by')])[2]");
		By level2Menu = By.linkText("Beverages");
		By level3Menu = By.linkText("Tea");
		By level4Menu = By.linkText("Green Tea");
	
		handleMenuSubMenuLevel4(level1Menu, level2Menu,level3Menu, level4Menu);
	
	
	
	
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenuSubMenuLevel4(By level1Menu, By level2Menu,By level3Menu, By level4Menu) throws InterruptedException {
		getElement(level1Menu).click();
		Thread.sleep(1500);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		getElement(level4Menu).click();
		
		
		
	}

}
