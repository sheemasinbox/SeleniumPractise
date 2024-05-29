package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MacBook");
		driver.findElement(By.xpath("//button/*[local-name()='svg' and @fill='none']")).click();
		
//		//*[local-name()='svg']
//      NOrmal xpath will not work for svg. Use the above path and then give the remaining attributes
	}

}
