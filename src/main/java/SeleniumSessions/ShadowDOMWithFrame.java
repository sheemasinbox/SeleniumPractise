package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMWithFrame {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");

/*
		//1. Browser -- Page -- shadow DOM(open) -- element
		String search_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\");";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement pizzaName  = (WebElement)js.executeScript(search_script);
		
		pizzaName.sendKeys("chicken pizza");
*/		
		
		//2. Browser -- page -- shadow DOM(open) -- iframe -- element
		String frame_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement frameElement = (WebElement)js.executeScript(frame_script);     //converting HTML element into WebElement
		
		driver.switchTo().frame(frameElement);
		
		driver.findElement(By.id("glaf")).sendKeys("Destiny Pass");
		
		driver.switchTo().defaultContent(); //to come out of iframe
	}

}
