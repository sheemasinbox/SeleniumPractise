package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessConcepts {

	public static void main(String[] args) {
		
		//headless vs headed
		//headless: no browser visibility. browser is in the background
		//testing is faster compared to normal mode
		//run TCS on CI CD/Jenkins/Linux : go for headless
		//recommended: not recommended as it does not simulate the actual user testing
		//local:
		//problems: its not an actual user simulation
		//complex apps/HTML DOM might not work in headless mode
		//alerts/popups : could be a problem
		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");   //arguments for headless mode
//		co.addArguments("--incognito");
//		WebDriver driver = new ChromeDriver(co);
		
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		WebDriver driver = new FirefoxDriver(fo);
		
		EdgeOptions eo = new EdgeOptions();
//		eo.UseChromium = true;
		eo.addArguments("--headless");
//		eo.addArguments("--inprivate");      //edge incognito
		WebDriver driver = new EdgeDriver(eo);
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
//		driver.quit();
		
		//headless options - ghostdriver, phantomJS, htmlunitdriver
		
		//aws -- ec2 linux -- black box -- headless -- docker(LINUX) -- UI
		
		
		
		
		//Other headless options: not needed
		//ghostdriver
		//phantomJS       (depricated)
		//htmlunitdriver  (now not a part of selenium)
		
		
		
		
		
		
		
		
		
		

	}

}
