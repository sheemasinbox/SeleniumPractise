package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalLinksConcept {

	public static void main(String[] args) {
		
		//1. total links
				//2. print the text of each link
				//3. avoid blank text
				//4. broken link -- later
		
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
		//Find all elements -->FEs
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int totalLinksCount = allLinks.size();
		System.out.println("Total number of links: " +totalLinksCount);
		
		ArrayList<String> linkTexts = new ArrayList<String>();
		
		for (int i=0; i<=allLinks.size()-1; i++) {
			String linkText = allLinks.get(i).getText();
			if(linkText.length() != 0) {
				linkTexts.add(linkText);
			}	
		}
//		System.out.println(linkTexts);
		
//		for (WebElement e : allLinks) {
//				if (e.getText() != "") {
//				linkTexts.add(e.getText());
//			}	
//		}
		
		int linksTextCount = linkTexts.size();
		System.out.println("Size of Link Texts is: "+linksTextCount);
		System.out.println("Links with display text are: "+(totalLinksCount - linksTextCount));
		System.out.println(linkTexts);
		
		
		//Print Total Text fields on a page
		List<WebElement> textFields = driver.findElements(By.className("form-control"));
		int textFieldCount = textFields.size();
		System.out.println("Total number of text fields: "+textFieldCount);
		
		
		
		

	}

}
