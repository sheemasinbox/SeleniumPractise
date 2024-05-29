package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		//frame : webelement : DOM
		//frame hierarchy:
		//Browser 
		//	-- Page :WebElements 
		//       -- Frame : webelements
		
		//frame   vs  iframe : 
		//frame is almost deprecated as per W3C standards
		//But usage wise it is same

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("apiautomation");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.manage().window().maximize();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		//to get frame info, rt-click on the element and check 'view frame source'
		
		
		
		
	}

}
