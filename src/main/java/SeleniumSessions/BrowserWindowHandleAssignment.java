package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent

		String parentWindowId = driver.getWindowHandle(); // parentWindowId
		System.out.println(parentWindowId);

		Thread.sleep(3000);

		// 1. Open 'linkedin'
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		getWindowHandles();

		// 2. Open 'facebook'
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		getWindowHandles();

		// 3. Open 'twitter'
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		getWindowHandles();

		// 4. Open 'youtube'
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		getWindowHandles();

	}

	public static void getWindowHandles() {
		Set<String> handles = driver.getWindowHandles(); // parent+child
		Iterator<String> it = handles.iterator();

		it.next(); // parent
		String childWindowId = it.next(); // child
		driver.switchTo().window(childWindowId);
		System.out.println("childWindow : " + driver.getCurrentUrl() + " " + driver.getTitle());
		driver.close();
	}

}
