package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterLinks {

	public static void main(String[] args) {
		
		//Launch Browser -- BrowserUtil class
				BrowserUtil brutil = new BrowserUtil();
				WebDriver driver = brutil.launchBrowser("chrome");
				brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
				
			//	By listGroup = By.className("list-group");
				
				List<WebElement> listGroup = driver.findElements(By.className("list-group-item"));
				System.out.println("Total links in Register right pane: "+listGroup.size());
				
				for (WebElement e : listGroup) {
					String linkText = e.getText();
					String hrefLink = e.getAttribute("href");
					System.out.println(linkText+" ---------------- "+hrefLink);
				}
				
				

	}

}
