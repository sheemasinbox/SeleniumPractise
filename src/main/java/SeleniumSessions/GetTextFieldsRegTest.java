package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextFieldsRegTest {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		List<WebElement> textFields = driver.findElements(By.className("form-control"));
		System.out.println(textFields.size());
		
		//By locators
		By classname = By.className("form-control");
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.name("email");
		By phone = By.name("telephone");
		By pwd = By.id("input-password");
		By pwdConfirm = By.id("input-confirm");
		
		
		//sendKeys to TextFields
		ElementUtil eutil = new ElementUtil(driver);
		eutil.doSendKeys(fname, "sheema");
		eutil.doSendKeys(lname, "Farheen");
		eutil.doSendKeys(email, StringUtility.getRandomEmail());
		eutil.doSendKeys(phone, "58896547");
		eutil.doSendKeys(pwd, "Farheen@1");
		eutil.doSendKeys(pwdConfirm, "Farheen@1");
		
		
		//Get the values from the Textfield entered above using "value" attribute
		ArrayList<String> values = eutil.getElementAttributeList(classname, "value");
		System.out.println(values);
		
		
		
		
		
	}

}
