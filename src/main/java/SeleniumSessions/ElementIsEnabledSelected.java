package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsEnabledSelected {
static WebDriver driver;
	
	public static void main(String[] args) {
		
		//isDisplayed() -- element present on the page or not
		//isEnabled() -- element is obviously present on page but its enabled or not
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/register");
		
		boolean f1 = driver.findElement(By.id("submitButton")).isDisplayed();
		boolean f2 = driver.findElement(By.name("agreeTerms")).isDisplayed();
		System.out.println("SubmitButton: "+f1);
		System.out.println("agreeTerms: "+f2);
		
		
		
		boolean flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("SubmitButtonEnabled: " +flag);   //false
		
		
		boolean chk_flag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("CheckBoxSelected: "+chk_flag);   //false
		
		driver.findElement(By.name("agreeTerms")).click();
		
		chk_flag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("CheckBoxSelected: "+chk_flag); //true
		
		flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("SubmitButtonEnabled: " +flag);   //true
		
		
		
		
	}

}
