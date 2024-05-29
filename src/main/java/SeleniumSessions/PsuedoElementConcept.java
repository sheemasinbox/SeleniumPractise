package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementConcept {

	public static void main(String[] args) {
		
		//Psuedo Classes - ::before , ::after  -- *mandatory symbol at the fields like *FirstName
		//In DOM, these Psuedo elements have no other properties
		//In Styles, content: '*', to capture this content no direct method is available, use JS
		//In browser-console give window.getComputedStyle(cssSelector, 'PsuedoElement').getPropertyValue();
		//cssSelector - document.querySelector('css of the tag under which we have this PsuedoElement')
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String script = "return window.getComputedStyle(document.querySelector('label[for=\"\\input-firstname\"\\]'),'::before').getPropertyValue('content');";

		JavascriptExecutor js =((JavascriptExecutor)driver);
		String mand_text = js.executeScript(script).toString();
		System.out.println(mand_text);
		
		if (mand_text.contains("*")) {
			System.out.println("FN is a mandatory field");
		}
	}

}
