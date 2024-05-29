package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		
		//type = file is mandatory (if not available ask developer to add it, as Sel does not support without type=file)
		//do not click on the choose file button.
		//this is a hack to directly select the file without opening the upload window
		driver.findElement(By.name("upfile")).sendKeys("C:/Users/Sheem/Documents/WebTableAssignment_InstructorExample.txt"); //path of file, maybe documents in sendKeys

		
		
		
		//other libs for files -- but not useful
		//sikuli  -- image based/resolution based
		//autoIT  -- only for windows machine -- wont work in docker, headless, jenkins, linux, mac
		
		
		
	}

}
