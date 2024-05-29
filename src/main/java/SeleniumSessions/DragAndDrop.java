package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
//		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);
		
		//Drag and Drop happens from element to element on the page -- Valid
		//file on the page -- Not Applicable

		WebElement srcEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		
		//This is a Builder Pattern as all the methods are returning the same class object reference

		Actions act = new Actions(driver);
/*		//Way#1:
		act.clickAndHold(srcEle)
				.moveToElement(targetEle)
					.release()
						.build()            //build() is not mandatory as Perform will call build internally
							.perform(); 
*/
		
//		Way#2:
//		act.dragAndDrop(srcEle, targetEle).perform();
		
		
//		Way#3:
		Action action = 
		act.clickAndHold(srcEle)
				.moveToElement(targetEle)
					.release()
						.build(); 
		
		action.perform();

		
		
		//Diff between Action and Actions
		//Actions - is a class
		//Action - is an interface
	}

}
