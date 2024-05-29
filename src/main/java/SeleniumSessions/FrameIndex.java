package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameIndex {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);
		
		driver.switchTo().frame(2);        //index starts from 0
		String text = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
		System.out.println(text);
	}

}
