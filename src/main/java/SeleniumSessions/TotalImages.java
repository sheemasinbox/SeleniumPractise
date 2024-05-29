package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		int imgCount = imagesList.size();
		System.out.println("Total number of images: "+imgCount);
		
		for(int i=0; i<=imagesList.size()-1; i++) {
			String altValue = imagesList.get(i).getAttribute("alt");
			String srcValue = imagesList.get(i).getAttribute("src");
			
			if(altValue.length()!=0) {
				System.out.println(altValue+" --- "+srcValue);
			}	
		}
		
//		for(WebElement e : imagesList) {
//			String altValue = e.getAttribute("alt");
//			String srcValue = e.getAttribute("src");
//			
//			System.out.println(altValue + "  ----  " + srcValue);
//		}


	}

}
