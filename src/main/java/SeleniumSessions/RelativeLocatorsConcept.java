package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsConcept {

	public static void main(String[] args) throws InterruptedException {
	/*
					  above ele
						  |
		Left of ele <--  ele  --> Right of ele
						  |
		near ele	  Below ele
	*/
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.linkText("Campbell River, Canada"));
		
//		driver.findElement(RelativeLocator.with(By.tagName("p")));
//instead of writing 'RelativeLocator.with()' every time, do a static import of with method. line#8
		
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);
		
		String rightNumber = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(rightNumber);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String near = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(near);
		
		
		
	}

}
