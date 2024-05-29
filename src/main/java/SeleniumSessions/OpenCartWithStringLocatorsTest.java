package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartWithStringLocatorsTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//String locators
		String fname = "firstname";
		String lname = "lastname";
		String emailID = "email";
		String telephone = "telephone";
		String pwd = "password";
		String confirmPwd = "confirm";
		
		
		//By locators
		By isSubscribeYes = By.cssSelector("input[value='1'][name='newsletter']");
		By isSubscribeNo = By.xpath("//input[@value='0'][@name='newsletter']");
		By isAgree = By.xpath("//input[@type='checkbox'][@name='agree']");
		By isContinue = By.xpath("//input[@value='Continue']");
		By isSuccess = By.tagName("h1");
		
		//launch url
		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtil eutil = new ElementUtil(driver);
		eutil.doSendKeys("name", fname, "Harry");
		eutil.doSendKeys("name", lname, "Potter");
		eutil.doSendKeys("name", emailID, StringUtility.getRandomEmail());
		eutil.doSendKeys("name", telephone, "9834532134");
		eutil.doSendKeys("name", pwd, "harry@345");
		eutil.doSendKeys("name", confirmPwd, "harry@345");
		eutil.doClick(isSubscribeYes);
		eutil.doClick(isAgree);
		eutil.doClick(isContinue);
		String actualMsg = eutil.doGetElementText(isSuccess);
		
		if(actualMsg.equals("Your Account Has Been Created!")) {
			System.out.println("Account Created -- Passed");
		}
		else {
			System.out.println("Account not Created -- Failed");
		}
		

	}

}
