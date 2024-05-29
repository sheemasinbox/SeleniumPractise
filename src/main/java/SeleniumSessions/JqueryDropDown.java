package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDown {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		
		Thread.sleep(3000);
		
		//By locators
		By dropdown = By.id("justAnInputBox");
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		//String[] value = {"choice 1", "choice 2", "choice 6"};
		
		
		//1. TC_01: single_selection
		//selectChoice(dropdown, choices, "choice 1");
		
		
		//2. TC_02: multi_selection
		//selectChoice(dropdown, choices, "choice 1", "choice 2 1", "choice 6", "choice 6 2 2");

		
		//3. TC_03: all selection
		selectChoice(dropdown, choices, "all");
		
		
	}
	
	
	/**
	 * This method is used to handle single, multiple and all selections
	 * For selecting all the options plz supply "all" in the method
	 * @param dropDownLocator
	 * @param choices
	 * @param value
	 * @throws InterruptedException
	 */
	//Using 3 dot parameter/ Spread parameter or argument/ varargs --array
	public static void selectChoice(By dropDownLocator, By choices, String... value) throws InterruptedException {
		driver.findElement(dropDownLocator).click();
		
		Thread.sleep(2000);
		List<WebElement> choicesList = driver.findElements(choices);
		
		if(!value[0].equals("all")) {
			
			System.out.println(choicesList.size());
			
			for(WebElement e : choicesList) {
				String text = e.getText();
				System.out.println(text);
				
				for (String val : value) {
					if(text.equals(val)) {
						e.click();
						}
				}
			}	
		}
		else {
			//all selection logic
			for(WebElement e : choicesList) {
				String text = e.getText();
				try {
					e.click();
				}catch(ElementNotInteractableException e1) {
					break;
				}
				
			}
		}
		
		
		
		
	}

}
