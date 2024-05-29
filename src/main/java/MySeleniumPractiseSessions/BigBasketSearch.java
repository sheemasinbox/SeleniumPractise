package MySeleniumPractiseSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumSessions.MyElementException;

public class BigBasketSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		System.out.println(driver.getTitle());

		// By locators:
		By searchField = By.xpath("(//input[@type='text' and contains(@placeholder, 'Search for')])[2]");
		By searchDropDown = By.xpath("//span[contains(@class,'gFDEBU')]");

		String value = driver.findElement(searchField).getAttribute("placeholder");
		System.out.println(value);

		// Call Methods:
		addItemsToCart(searchField, "fruits", searchDropDown, "1 kg", "Banana - Yelakki");
		addItemsToCart(searchField, "fruits", searchDropDown, "1 kg", "Pomegranate - Regular");
		addItemsToCart(searchField, "bakery", searchDropDown, "400 g", "Cashew Biscuits");

	}

	// Methods:
	public static void searchItems(By searchFieldLocator, String searchValue) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(searchFieldLocator).click();
		driver.findElement(searchFieldLocator).clear();
		driver.findElement(searchFieldLocator).sendKeys(searchValue);
	}

	public static void addItemsToCart(By searchFieldLocator, String searchValue, By searchDropDownLocator,
			String weight, String item) throws InterruptedException {

		searchItems(searchFieldLocator, searchValue);

		Thread.sleep(4000);
		List<WebElement> searchListItems = driver.findElements(searchDropDownLocator);
		System.out.println("Total items displayed on page: " + searchListItems.size());

		boolean itemFound = false;
		for (WebElement e : searchListItems) {
			String text = e.getText();
//			System.out.println(text);		

			if (text.equals(item)) {
				
				itemFound = true;
				String weightText = getWeight(text);
				if (weightText.equals(weight)) {
					String priceText = getPrice(text);

					String discountText = null;
					try {
						discountText = getDiscount(text);
					} catch (NoSuchElementException e1) {

					}

					WebElement button = getButton(text);

					System.out.println(text + " : " + weightText + " , " + priceText + " , " + discountText);
					button.click();
					System.out.println(text + " added to cart");
					break;
				}
			}
//			
		}
		if(!itemFound) {
			System.out.println(item+" is not available");
		}

	}

	// get text of weight, price, discount and WebElement of button of an item
	public static String getWeight(String item) {
		return driver.findElement(By.xpath(
				"//span[text()='" + item + "']/ancestor::div[contains(@class,'flex-1')]/following-sibling::span"))
				.getText();

	}

	public static String getPrice(String item) {
		return driver.findElement(By.xpath("//span[text()='" + item
				+ "']/ancestor::div[contains(@class,'flex-1')]/following-sibling::div/span[contains(@class,'gpRcpM')]"))
				.getText();

	}

	public static String getDiscount(String item) {
		return driver.findElement(By.xpath("//span[text()='" + item
				+ "']/ancestor::div[contains(@class,'flex-1')]/following-sibling::div/span[contains(@class,'ZMMNy')]"))
				.getText();

	}

	public static WebElement getButton(String item) {
		return driver.findElement(By.xpath(
				"//span[text()='" + item + "']/ancestor::div[contains(@class,'flex-1')]/following-sibling::button"));

	}

}
