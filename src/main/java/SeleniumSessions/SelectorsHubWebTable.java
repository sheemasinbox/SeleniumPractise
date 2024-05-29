package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorsHubWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

//		selectUser("John.Smith");
//		ArrayList<String> userDetails = getUserDetails("John.Smith");
//		System.out.println(userDetails);
		
		System.out.println("Full Table Data");
		System.out.println(getTableHeaders());
		getTableData();
		selectAllUsers();
	}

	//Methods:
	public static void selectUser(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}
	
	public static void selectAllUsers() {
		List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='resultTable']//td/input[@type='checkbox']"));
		
		for (WebElement c : checkboxList) {
			c.click();
		}
		System.out.println("All users selected");
	}

	public static ArrayList<String> getUserDetails(String userName) {
		List<WebElement> detailsList = driver
				.findElements(By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td"));
		ArrayList<String> data = new ArrayList<String>();

		for (WebElement e : detailsList) {
			String userDetails = e.getText();
			data.add(userDetails);
		}
		return data;
	}

	public static ArrayList<String> getTableHeaders() {
		List<WebElement> tableHeadersList = driver.findElements(By.xpath("//table[@id='resultTable']//tr/th"));
		ArrayList<String> tableheaders = new ArrayList<String>();

		for (WebElement h : tableHeadersList) {
			String headers = h.getText();
			tableheaders.add(headers);
		}
		return tableheaders;

	}

	public static void getTableData() {

		int rowsCount = driver.findElements(By.xpath("//table[@id='resultTable']//tr")).size();
		int colsCount = driver.findElements(By.xpath("(//table[@id='resultTable']//tr)[2]/td")).size();

		List<WebElement> rowsDataList = driver.findElements(By.xpath("//table[@id='resultTable']//tr"));

		ArrayList<String> columnData = new ArrayList<String>();

		for (int i = 2; i <= rowsCount; i++) {

			List<WebElement> colsDataList = driver
					.findElements(By.xpath("(//table[@id='resultTable']//tr)[" + i + "]/td"));

			for (WebElement col : colsDataList) {

				String colsData = col.getText();
				columnData.add(colsData);
			}
			System.out.println(columnData);
			columnData.clear();

		}

	}
	
	

}
