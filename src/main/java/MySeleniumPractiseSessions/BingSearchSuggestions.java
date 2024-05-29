package MySeleniumPractiseSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchSuggestions {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.bing.com/");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='sa_drw']//span"));
		
		for (WebElement e : searchlist) {
			String text = e.getText();
			System.out.println(text);
			
//			if (text.equals("selenium interview questions")) {
//				e.click();
//				break;
//			}
			
		}
		
		
			
		
	}

}

