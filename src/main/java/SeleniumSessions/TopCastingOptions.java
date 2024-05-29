package SeleniumSessions;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//1. WD d = new CD();
				//valid -- recommended
				//run tests on local machine
				//WebDriver driver = new ChromeDriver();
				
				//2. SC driver = new CD();
				//valid -- not recommended
				//SearchContext driver = new ChromeDriver();
				
				//3. RWD driver = new CD();
				//valid -- recommended
				//RemoteWebDriver driver = new ChromeDriver();
				
				//4. valid -- not recommended
				//ChromiumDriver driver = new ChromeDriver();

				//5. WD driver = new RWD();
				//valid -- recommended
				//run tests on the remote/server/cloud machine/grid//sauce labs/browsertsack/lambdatest
				//WebDriver driver = new RemoteWebDriver(serverURL, capabilities);
				
				//6. valid -- not recommended
				//SearchContext driver = new RemoteWebDriver(serverURL, capabilities);
				
				
				//7. CD driver = new ChromeDriver();
				//valid but works only for chrome browser
				//ChromeDriver driver = new ChromeDriver();
				//FirefoxDriver driver = new FirefoxDriver();
				

	}

}
