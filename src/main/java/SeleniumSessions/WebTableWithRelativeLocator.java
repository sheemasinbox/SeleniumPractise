package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class WebTableWithRelativeLocator {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new FirefoxDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);
		
		WebElement playerEle = driver.findElement(By.linkText("Joe.Root"));
		
		driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(playerEle)).click();
		
		
		//RelativeLocators are better when there is only 1 element toLeftOf or toRightOf baseElement.
		//When there are multiple elements it might pick up all the elements and we have to create multiple 
		//boundaries to fetch the desired element.
		List<WebElement> playerData = driver.findElements(with(By.xpath("//table[@id='resultTable']//td")).toRightOf(playerEle));
		
		for (WebElement p : playerData) {
			System.out.println(p.getText());
		}

	}

}
