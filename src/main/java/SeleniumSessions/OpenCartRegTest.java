package SeleniumSessions;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegTest {

	public static void main(String[] args) {
		
		//By Locators
		By firstName = By.id("input-firstname");
		By lastName = By.name("lastname");
		By emailID = By.xpath("//*[@id=\"input-email\"]");
		By telephone = By.cssSelector("#input-telephone");
		By pwd = By.id("input-password");
		By confirmPwd = By.name("confirm");
		
		By isSubscribeYes = By.cssSelector("input[value='1'][name='newsletter']");
		By isSubscribeNo = By.xpath("//input[@value='0'][@name='newsletter']");
		
		By isAgree = By.xpath("//input[@type='checkbox'][@name='agree']");
		By isContinue = By.xpath("//input[@value='Continue']");
		
		By isSuccess = By.tagName("h1");
		
		
		//Launch Browser -- BrowserUtil class
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.navigate().back();
		
		
		//Enter field values -- ElementUtil class
		ElementUtil eutil = new ElementUtil(driver);
		eutil.doSendKeys(firstName, "Sheema");
		eutil.doSendKeys(lastName, "Farheen");
		eutil.doSendKeys(emailID, StringUtility.getRandomEmail());
		eutil.doSendKeys(telephone, "8769870934");
		eutil.doSendKeys(pwd, "sheema@123");
		eutil.doSendKeys(confirmPwd, "sheema@123");
		eutil.doClick(isSubscribeNo);
		eutil.doClick(isAgree);
		eutil.doClick(isContinue);
		
		String actualMessage = eutil.doGetElementText(isSuccess);
		if (actualMessage.equals("Your Account Has Been Created!")) {
			System.out.println("Registraion Successful -- Passed");
		}
		else {
			System.out.println("Registraion Unsuccessful -- Failed");
		}
		
		brutil.getPageURL();
		
	}

}
