package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //parent
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();
		
		//1st: fetch the window Ids
		//set is a non-ordered based collection.
		//getWindowHandles generates unique Ids and not ordered. So, you cannot fetch using index
		//since driver is originally pointing to parent window, it will get stored in the handles first and then the child windows
		//Use Iterator to fetch values
		
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();  //Iterator points just above the set object with the handles
		
		String parentWindowId = it.next();
		System.out.println("parent window id : " +parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window Id : " +childWindowId);
		
		//2nd: switching work:
		driver.switchTo().window(childWindowId);
		System.out.println("Child window url : "+driver.getCurrentUrl());   //twitter
		
		driver.close();  //close the child window  ---- driver is lost
		
		//to get the driver back to the parent window
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window url : "+driver.getCurrentUrl());   //orangehrm
		
		driver.quit();
		

		
		
			
	}

}
