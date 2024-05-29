package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		String browserName = "chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browserName);
		
		brUtil.launchURL("https://www.amazon.com/");
		String actualTitle = brUtil.getPageTitle();
		
		if (actualTitle.contains("Amazon")) {
			System.out.println("title -- Pass");
		}
		else {
			System.out.println("title -- Fail");
		}
		
		String url = brUtil.getPageURL();
		if (url.contains("amazon.com")) {
			System.out.println("url -- Pass");
		}
		else {
			System.out.println("url -- Fail");
		}
		
		brUtil.closeBrowser();		
		
		
		
		
		
		
		

	}

}
