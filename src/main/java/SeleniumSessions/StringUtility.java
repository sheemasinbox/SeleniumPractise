package SeleniumSessions;

public class StringUtility {

	private StringUtility() { }     //private dummy constructor to prevent object creation of this class
	
	//RandomEmailGenerator
	public static String getRandomEmail() {
		return "automation"+System.currentTimeMillis()+"@"+"opencart.com";
//		return "automation"+UUID.randomUUID()+"@"+"opencart.com";
	}
	
}
