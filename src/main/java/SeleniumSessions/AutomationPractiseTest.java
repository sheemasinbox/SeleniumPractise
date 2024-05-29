package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPractiseTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://rahulshettyacademy.com/AutomationPractice/");
		String title = brutil.getPageTitle();
		System.out.println("Title is: " +title);
		String url = brutil.getPageURL();
		System.out.println("URL is: "+url);
		
		brutil.launchURL("https://www.rahulshettyacademy.com/");
		String title1 = brutil.getPageTitle();
		System.out.println("Title is: " +title1);
		String url1 = brutil.getPageURL();
		System.out.println("URL is: "+url1);
		driver.navigate().back();
		
		
		//By locators:
		//Radio Buttons
		By radioName = By.xpath("//div[@id='radio-btn-example']/fieldset/legend");
		By radio1 = By.xpath("//input[@class='radioButton'][@value='radio1']");	
		By radio2 = By.cssSelector("input[class='radioButton'][value='radio2']");
		By radio3 = By.cssSelector("//*[@id=\"radio-btn-example\"]/fieldset/label[3]/input");
		
		//Checkboxes
		By checkbox1 = By.id("checkBoxOption1");
		By checkbox2 = By.id("checkBoxOption2");
		By checkbox3 = By.id("checkBoxOption3");
		
		//Links
		By restAPILink = By.partialLinkText("REST");
		By soapUILink = By.linkText("SoapUI");
		By appiumLink = By.linkText("Appium");
		By jMeterLink = By.cssSelector("a[href='https://jmeter.apache.org/']");
		
		ElementUtil eutil = new ElementUtil(driver);
		String radioNameText = eutil.doGetElementText(radioName);
		System.out.println("Radio button heading is: "+radioNameText);
		
		eutil.doClick(radio1);
		eutil.doClick(checkbox2);
		String jMeterlinkText = eutil.doGetElementText(jMeterLink);
		System.out.println("jMeterlinkText is: "+jMeterlinkText);
		
		
		
		
		
	}

}
