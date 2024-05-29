package MySeleniumPractiseSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	WebDriver driver;
	
	//Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods
	//Get WebElement
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	} 
	
	//SendKeys to field
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	//Click 
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	//Get Count of Elements
	public int getElementsCount(By locator) {
		List<WebElement> elements = getElements(locator);
		return elements.size(); 
	}
	
	
	
	//Get text of the elements
	public ArrayList<String> getElementsText(By locator) {
		List<WebElement> elements = getElements(locator);
		ArrayList<String> elementsText = new ArrayList<String>();
		
		for (WebElement e : elements) {
			String text = e.getText();
			elementsText.add(text);
		}
		return elementsText;
	}
	
	
	//
	public void printElementsText(By locator) {
		List<WebElement> elements = getElements(locator);
		
		int count = 1;
		for (WebElement e : elements) {
			String text = e.getText();
			System.out.println(count+" . "+text);
			count++;
		}
	}
	
	//SearchResultsAssertion -- Checks for partial text "value" in the List of results
	public void searchResultsAssertion(By locator, String value) {
		
		ArrayList<String> searchResultsList=getElementsText(locator);

		String result="PASS";
		for (String label : searchResultsList) {
			
			if(!label.toLowerCase().contains(value.toLowerCase())) {
				result="FAIL";
				break;
			}
		}
		
		System.out.println(result);
	}

}
