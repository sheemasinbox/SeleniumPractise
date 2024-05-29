package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGMapHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		//cssSelector:
//      String map_css1 = svg#map-svg g#regions > g              ---- > gives direct child
//      String map_css2 = svg#map-svg g#regions g.region         ---- space gives direct+indirect child
				
		String map_xpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']/*[name()='g']";
		List<WebElement> statesList= driver.findElements(By.xpath(map_xpath));
		
		Actions act = new Actions(driver);
		
		for (WebElement s : statesList) {
			act.moveToElement(s).perform();
			String stateId = s.getAttribute("id");
			System.out.println(stateId);
			Thread.sleep(500);
		}

	}

}
