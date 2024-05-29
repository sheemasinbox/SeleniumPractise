package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownWithoutUsingSelectClass {

static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/30-day-free-trial/");

//X		By country = By.id("Form_getForm_Country");
		
		//not allowed to use Select class and select value from DropDown
		
		By options = By.xpath("//select[@id='Form_getForm_Country']/option");
		doSelectValueFromDropDown(options,"India");
		doSelectValueFromDropDown(options,"Australia");
		
		doSelectValueFromDropDown(options,null);
		
	}
	
	//Using value
	public static void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	//Using Index
	public static void doSelectValueFromDropDown(By locator, int index) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		
		int count = 0;                 //0 dropdown value= 'country'
		for(WebElement e : optionsList) {
			String text = e.getText();
			
			if(count == index) {
				e.click();
				break;
			}
			count++;
		}
	}
	
	
}
