package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
//		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		driver.get("https://www.spicejet.com/");
		
		//driver.switchTo().alert().dismiss();

//		WebElement content = driver.findElement(By.className("menuLink"));
		
//		Actions act = new Actions(driver);
//		act.moveToElement(content).perform();
//		act.moveToElement(content).build().perform();
		// single action -- perform
		// single action -- build.perform
		// multiple actions -- build.perform
		// act.a1.a2.a3.a4.build().perform();  -- Valid
		// act.a1.build().perform();   -- Valid
		// act.a1.perform();  -- Valid
		// act.a1.build();   -- Invalid
		// act.a1;           -- Invalid
		
//		Thread.sleep(1500);
//		
//		driver.findElement(By.linkText("COURSES")).click();
		
		//Locators for mrbool.com:
//		By parent = By.className("menuLink");
//		By subMenu = By.linkText("COURSES");
//		handleMenuSubMenu(parent,subMenu);
		
		//Locators for Spicejet.com
		By parent = By.xpath("//div[text()='Add-ons']");
		By subMenu = By.xpath("//a[@data-testid='test-id-SpiceMax']");
		By valueLocator = By.xpath("//a[@data-testid='test-id-Taxi']");
//		handleMenuSubMenuLevel2(parent,subMenu);
		
		By subMenuList = By.xpath("//a[@data-testid='test-id-SpiceMax']/parent::div/parent::div/parent::div/child::div");
		getElementsList(parent, subMenuList, "Taxi", valueLocator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void handleMenuSubMenuLevel2(By parentMenuLocator, By subMenuLocator) throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		getElement(subMenuLocator).click();	
	}
	
	public static void getElementsList(By parentMenuLocator, By subMenuList, String value, By valueLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		
		List<WebElement> eleList = getElements(subMenuList);
		
		for(WebElement l : eleList) {
			String text = l.getText();
			System.out.println(text);
			
			if(text.contains(value)) {
//				act.moveToElement(getElement(valueLocator)).perform();
				Thread.sleep(1500);
				getElement(valueLocator).click();
			}
		}
	}

}
