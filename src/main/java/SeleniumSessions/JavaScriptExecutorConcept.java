package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		//browser understands only JS
		//JavascriptExecutor is an interface having method executeScript()
		
		//In browser console, to print give console.log(100);  -- prints 100
		//alert('hello Java!');
		//confirm('hello');
		//prompt('enter name:');
		//Similarly we can do this from Sel Java code as well
		
		WebDriver driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.get("https://app.hubspot.com/login");
		
		//ChromeDriver extends ChromiumDriver extends RemoteWebDriver implements WebDriver, JavascriptExecutor
		//In Java Interface - Interface casting is allowed
		JavascriptExecutor js = (JavascriptExecutor)driver ;   //converting driver into JavascriptExecutor
//		
//		String title = js.executeScript("return document.title;").toString();    //similar to driver.getTitle(); in Sel
//		System.out.println(title);
//		
//		String url = js.executeScript("return document.URL;").toString();    //similar to driver.getCurrentUrl(); in Sel
//		System.out.println(url);
//		
//		WebElement logo = driver.findElement(By.id("logo"));
//		String cssValue = logo.getCssValue("backgroundColor");
//		System.out.println(cssValue);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
//		jsUtil.generateAlert("This is my message alert");
		
//		String pageText  = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		if (pageText.contains("MacBook")) {
//			System.out.println("Pass");
//		}
		
//		WebElement element = driver.findElement(By.xpath("//a[text()='Canon EOS 5D']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
//		jsUtil.scrollIntoView(element);
		
//		String zoom = "document.body.style.zoom = '90%'";
//		js.executeScript(zoom);
//		jsUtil.zoomChromeEdgeSafari("50");
		
//		WebElement loginForm = driver.findElement(By.id("hs-login"));
//		jsUtil.drawBorder(loginForm);
		
		WebElement userID = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		jsUtil.flash(userID);
		userID.sendKeys("testing@gmail.com");
		jsUtil.flash(password);
		password.sendKeys("testing@123");
		
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		jsUtil.clickElementByJS(loginBtn);
			
		

	}

}
