package SeleniumSessions;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp {

	public static void main(String[] args) {

		//Basic Auth
		
		WebDriver driver = new ChromeDriver();
		
		//1. directly give username, pwd in the url
		String username = "admin";
		String password = "admin";
		
	//	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");
	//	driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth/");
		
		//Authentication PopUps -- signIn --- like in APIs
		//you cannot inspect it
		//NOt JS pop-up
		//append username & password in url itself
		//if password has '@' it will not work
		
		//"https://username:password@domainname"
		
		
		//sel 4.x
		//2. HasAuthentication interface implemented by Chrome Driver
		//register() is a method in HasAuthentication interface
		//UsernameAndPassword is a class, its constructor has 2 parameters
		// pwd having @ will also work
		
		((HasAuthentication)driver).register(() ->  new UsernameAndPassword(username,password));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth/");
		

	}

}
