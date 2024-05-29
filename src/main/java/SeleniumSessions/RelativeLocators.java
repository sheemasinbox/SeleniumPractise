package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.id("input-email"));
		
		String text = driver.findElement(with(By.cssSelector("label[for='input-email']")).above(ele)).getText();
		System.out.println(text);
		
		WebElement header = driver.findElement(By.xpath("//h2[text()='New Customer']"));
		WebElement continueBtn = driver.findElement(By.linkText("Continue"));
		
		List<WebElement> paraList = driver.findElements(with(By.tagName("p")).below(header).above(continueBtn));
		
		for (WebElement e : paraList) {
			System.out.println(e.getText());
		}
		
		
		
	}

}
