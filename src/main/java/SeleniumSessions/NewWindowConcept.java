package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //parent
		
		String parentWindowId = driver.getWindowHandle();
		
		//Sel 4.x onwards
		//opens a new blank window/Tab and switches focus to it automatically
		//WindowType is an enum which can maintain different types of constants
//		driver.switchTo().newWindow(WindowType.TAB);     //opens new TAB
		driver.switchTo().newWindow(WindowType.WINDOW);  //opens new WINDOW
		
		driver.get("https://www.google.com/");    //google
		
		driver.close();   //close google
		
		//get the driver back to the parent window Id
		driver.switchTo().window(parentWindowId);
		
		System.out.println(driver.getTitle());    //orange hrm
		
		
		
	}

}
