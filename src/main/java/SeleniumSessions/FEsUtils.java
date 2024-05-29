package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FEsUtils {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//By locators
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		//Count
		int linksCount = getElementsCount(links);
		int imagesCount = getElementsCount(images);
		System.out.println("Total links: "+linksCount);
		System.out.println("Total images: "+imagesCount);
		
		
		//Print Texts of Elements
		ArrayList<String> eleTexts = getElementsTextList(links);
		System.out.println(eleTexts);
		
		if (eleTexts.contains("Help")) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		
		//Print Attributes of Elements
		ArrayList<String> eleAltValues = getElementAttributeList(images, "alt" );
		System.out.println(eleAltValues);

	}
	
	//Methods
	//getElements
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	//Count
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	//get a list of text of all elements
	public static ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length()!=0) {
				eleTextList.add(text);
			}	
		}
		return eleTextList;
	}

	
	//get a list of all the Attribute values of elements
	public static ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			if (attrValue.length()!=0)
				eleAttrList.add(attrValue);
		}
		return eleAttrList;
		
	}
	
}
