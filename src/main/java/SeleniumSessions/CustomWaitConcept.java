package SeleniumSessions;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//Thread.sleep is static wait -- converting into ---> Dynamic Wait
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email11");
		retryingElement(emailId, 10).sendKeys("sheema@gmail.com");
		
		

	}
	
	//Methods:
	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempts = 0;
		
		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				System.out.println("Element is found..."+locator+" in attempts: "+attempts);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found..."+" in attempts: "+attempts);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
			
		}
		
		if(element == null) {
			System.out.println("Element is not found... tried for "+timeOut+" times"+ " with the interval of "+500+" milliseconds");
			throw new MyElementException("No Such Element");
		}
		return element;
		
	}
	
	public static WebElement retryingElement(By locator, int timeOut, int intervalTime) {
		WebElement element = null;
		int attempts = 0;
		
		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				System.out.println("Element is found..."+locator+" in attempts: "+attempts);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found..."+" in attempts: "+attempts);
				try {
					Thread.sleep(intervalTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
			
		}
		
		if(element == null) {
			System.out.println("Element is not found... tried for "+timeOut+" times"+ " with the interval of "+intervalTime+" milliseconds");
			throw new MyElementException("No Such Element");
		}
		return element;
		
	}

}
