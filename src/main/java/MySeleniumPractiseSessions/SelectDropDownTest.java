package MySeleniumPractiseSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownTest {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/30-day-free-trial/");
		
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		
		List<WebElement> dropDownOptions = driver.findElements(By.xpath("//select[@id='Form_getForm_Country']/option"));
		System.out.println(dropDownOptions.size());
		
		Select select = new Select(countryDropDown);
//		select.selectByIndex(1);
//		select.selectByValue("Argentina");
		select.selectByVisibleText("Bahamas");
		
		
		
		
		
	}

}
