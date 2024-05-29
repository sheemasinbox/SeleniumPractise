package SeleniumSessions;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("apiautomation");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.manage().window().maximize();
		driver.switchTo().frame("mainpanel");
//		driver.findElement(By.linkText("CONTACTS")).click();
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		
		ArrayList<String> userData = getAllUserDetails("Joe Root");
	
		System.out.println(userData);	
		
	}
	
	
	public static ArrayList<String> getAllUserDetails(String name) {
		
		selectCheckBox(name);
		
		ArrayList<String> data = new ArrayList<String>(); 
		String nameText = getContactName(name);
		String company = getCompany(name);
		String phone = getPhone(name);
		String homePhone = getHomePhone(name);
		String mobile = getMobile(name);
		String email = getEmail(name);
		data.add(nameText);
		data.add(company);
		data.add(phone);
		data.add(homePhone);
		data.add(mobile);
		data.add(email);
		return data;
		
	}
	
	public static String getContactName(String name) {
		return driver.findElement(By.xpath("(//a[text()='"+name+"'])[1]")).getText();
	
	}
	
	public static void selectCheckBox(String name) {
		driver.findElement(By.xpath("(//a[text()='"+name+"'])[1]/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public static String getCompany(String name) {
		return driver.findElement(By.xpath("(//a[text()='"+name+"'])[1]/parent::td/following-sibling::td/a[@context='company']")).getText();
	}
	
	public static String getPhone(String name) {
		return driver.findElement(By.xpath("((//a[text()='"+name+"'])[1]/parent::td/following-sibling::td/span[@context='phone'])[1]")).getText();
	}
	
	public static String getHomePhone(String name) {
		return driver.findElement(By.xpath("((//a[text()='"+name+"'])[1]/parent::td/following-sibling::td/span[@context='phone'])[2]")).getText();
	}
	
	public static String getMobile(String name) {
		return driver.findElement(By.xpath("((//a[text()='"+name+"'])[1]/parent::td/following-sibling::td/span[@context='phone'])[3]")).getText();
	}
	
	public static String getEmail(String name) {
		return driver.findElement(By.xpath("(//a[text()='"+name+"'])[1]/parent::td/following-sibling::td/a[contains(@href,'mailto')]")).getText();
	}
	
	

}
