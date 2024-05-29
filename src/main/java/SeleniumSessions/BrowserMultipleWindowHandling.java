package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //parent
		
		String parentWindowId = driver.getWindowHandle();    //gives the windowId where currently the driver is pointing -- parentId
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();  //child
		driver.findElement(By.xpath("//a[contains(@href, 'linkedin')]")).click();  //child
		driver.findElement(By.xpath("//a[contains(@href, 'youtube')]")).click();  //child
		driver.findElement(By.xpath("//a[contains(@href, 'facebook')]")).click();  //child

		//fetch window handles
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println("window url : "+driver.getCurrentUrl());
			
			
			//close all windows except parentWindow
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}	
		}
		
		driver.switchTo().window(parentWindowId);  //get driver back to parentWindow
		System.out.println(driver.getCurrentUrl()+" "+driver.getTitle());
		
		
	}

}
