package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJsPopUpHandling {

	public static void main(String[] args) {
		
		//JS Pop-Ups:
		//1.alert
		//2.confirm
		//3.prompt
		//When JS pop-ups are on screen you cannot click on anything else on screen.
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts/");
		
		//1.Alert
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		//Alert is an interface
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		
//		alert.accept();    //click on OK button
////		alert.dismiss();   //cancel alert
	
		//2.Confirmation pop-up
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		
//		alert.accept();   //click on ok button
////		alert.dismiss();
		
		
		//3.prompt
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
		//While doing it with Selenium, you will not be able to see the text being entered on the screen. But the value will be entered.
		alert.sendKeys("Sheema");    
		
		alert.accept();
//		alert.dismiss();
		
		
		
		
	}

}
