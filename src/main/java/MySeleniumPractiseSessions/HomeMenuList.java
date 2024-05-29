package MySeleniumPractiseSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeMenuList {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		
		ElementUtil eutil = new ElementUtil(driver);
		
		By menu = By.xpath("//div[@class='navbar-collapse collapse clearfix']/ul/li/a");
		
		
		System.out.println(eutil.getElementsCount(menu));

//		eutil.getElementsText(menu);
		eutil.printElementsText(menu);
		
		
		
		//

	}

}
