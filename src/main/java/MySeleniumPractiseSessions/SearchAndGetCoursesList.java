package MySeleniumPractiseSessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAndGetCoursesList {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		
		ElementUtil eutil = new ElementUtil(driver);
		
		//By locators
		By searchText = By.id("search-courses");
		By searchButton = By.xpath("//button[@class='btn search btn-default btn-lg']");
		By searchResults = By.className("course-listing-title");
		
		
		eutil.doSendKeys(searchText, "selenium");
		eutil.doClick(searchButton);
		
		int count = eutil.getElementsCount(searchResults);
		System.out.println("Number of Results: "+count);
		
		eutil.printElementsText(searchResults);
		
		eutil.searchResultsAssertion(searchResults, "selenium");
		


	}
	
	

}
