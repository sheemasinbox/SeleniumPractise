package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//SRP - Single Responsibility Principle design pattern
public class ElementUtil {

	private WebDriver driver;
	
	private final String DEFAULT_ELEMENT_TIME_OUT_MESSAGE = "Time out... Element is not found...";
	private final String DEFAULT_ALERT_TIME_OUT_MESSAGE = "Time out... Alert is not found...";

	// Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	// null blank value check
	private void nullBlankCheck(String value) {
		if (value == null || value.length() == 0) {
			throw new MyElementException(value + "visible text cannot be null");
		}
	}

	public By getBy(String locatorType, String locatorValue) {

		By locator = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;
		default:
			break;
		}
		return locator;
	}

	// Element util
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	// overridden
	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page");
			e.printStackTrace();
			// return null;
		}
		return element;
	}

	// Action util
	public void doSendKeys(By locator, String value) {
		nullBlankCheck(value);
		getElement(locator).sendKeys(value);
	}
	
	// overridden
	public void doSendKeys(By locator, String value, int timeOut) {
		nullBlankCheck(value);
		waitForElementVisible(locator, timeOut).sendKeys(value);
	}

	// overridden
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		nullBlankCheck(value);
		getElement(locatorType, locatorValue).sendKeys(value);
	}

	// Click
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	//overridden
	public void doClick(By locator, int timeOut) {
		waitForElementVisible(locator, timeOut).click();
	}

	// getText
	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	// get Attribute value
	public String doElementGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isElementExist(By locator) {
		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}

	public boolean multipleElementExist(By locator) {
		if (getElements(locator).size() > 0) {
			return true;
		}
		return false;
	}

	// Overridden
	public boolean multipleElementExist(By locator, int elementCount) {
		if (getElements(locator).size() == elementCount) {
			return true;
		}
		return false;
	}

	// getElements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// Count
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	// get a list of text of all elements
	public ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// get a list of all the Attribute values of elements
	public ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			if (attrValue.length() != 0)
				eleAttrList.add(attrValue);
		}
		return eleAttrList;

	}

	// *********SelectBased DropDown Utils **********8/

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String visibleText) {
		nullBlankCheck(visibleText);

		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText); // if visible text is incorrect/not present
		} catch (NoSuchElementException e) {
			System.out.println("visible text is not present in the dropdown");
			e.printStackTrace();
			throw new MyElementException("text not present");
		}
	}

	public void doSelectByValue(By locator, String value) {
		nullBlankCheck(value);
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public List<String> getDropDownOptionsTextList(By locator) {
		List<WebElement> optionsList = getDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			String optionText = e.getText();
			optionsTextList.add(optionText);
		}
		return optionsTextList;

	}

	public List<WebElement> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();

	}

	public void doSelectDropDownValue(By locator, String value) {
		nullBlankCheck(value);
		List<WebElement> optionsList = getDropDownOptionsList(locator);
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

	public void printSelectDropDownValue(By locator) {

		List<WebElement> optionsList = getDropDownOptionsList(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

		}

	}

	// Select from DropDown without using Select class and select value
	public void doSelectValueFromDropDown(By locator, String value) {
		nullBlankCheck(value);
		List<WebElement> optionsList = getElements(locator);
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals("India")) {
				e.click();
				break;
			}
		}
	}

	// Using Index
	public void doSelectValueFromDropDown(By locator, int index) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());

		int count = 0; // 0 dropdown value= 'country'
		for (WebElement e : optionsList) {
			String text = e.getText();

			if (count == index) {
				e.click();
				break;
			}
			count++;
		}
	}

	//Dynamic search and click
	public void doSearch(By searchlocator, By searchSuggestions, String searchKey, String value) throws InterruptedException {
			
			doSendKeys(searchlocator, searchKey);
			Thread.sleep(3000);
			
			List<WebElement> sugglist = getElements(searchSuggestions);
			System.out.println(sugglist.size());
			
			for (WebElement e : sugglist) {
				String text = e.getText();
				System.out.println(text);
				
				if (text.toLowerCase().contains(value.toLowerCase())) {
					e.click();
					break;
				}
				else {
					continue;
				}
				
			}

	}
	
	//******************Actions Utils*************
	public void handleMenuSubMenuLevel2(By parentMenuLocator, By subMenuLocator) throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		doClick(subMenuLocator);	
	}
	
	public void handleMenuSubMenuLevel4(By level1Menu, By level2Menu,By level3Menu, By level4Menu) throws InterruptedException {
		doClick(level1Menu);
		Thread.sleep(1500);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		doClick(level4Menu);	
	}
	
	public void handleMenuSubMenuLevel4MouseHover(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(level1Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		doClick(level4Menu);	
	}	
	
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	
	//******************Wait utils**********//
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
		/**
		 * An expectation for checking that an element is present on the DOM of a page. 
		 * This does not necessarily mean that the element is visible.
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public WebElement waitForElementPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		/**
		 * An expectation for checking that an element is present on the DOM of a page and visible. 
		 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
		 * @param locator
		 * @param timeOut
		 * default interval time = 500ms
		 * @return
		 */
		public WebElement waitForElementVisible(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		public WebElement waitForElementVisible(By locator, int timeOut, int intervalTime) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		/**
		 * An expectation for checking that there is at least one element present on a web page.
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		
		public List<WebElement> waitForElementsPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(timeOut))
									.pollingEvery(Duration.ofSeconds(pollingTime))
									.ignoring(NoSuchElementException.class)
									.withMessage(DEFAULT_ELEMENT_TIME_OUT_MESSAGE);
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		
		/**
		 * An expectation for checking that all elements present on the web page that match the locator
         * are visible. Visibility means that the elements are not only displayed but also have a height
         * and width that is greater than 0.
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		public String waitForTitleContains(String titleFraction, int timeOut) {
			WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.titleContains(titleFraction));
				return driver.getTitle();
			}
			catch(Exception e) {
				System.out.println("title is not found within: "+timeOut);
			}
			return null;
		}
		
		public String waitForTitleIs(String title, int timeOut) {
			WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.titleIs(title));
				return driver.getTitle();
			}
			catch(Exception e) {
				System.out.println("title is not found within: "+timeOut);
			}
			return null;
		}
		
		public String waitForUrlContains(String UrlFraction, int timeOut) {
			WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.urlContains(UrlFraction));
				return driver.getCurrentUrl();
			}
			catch(Exception e) {
				System.out.println("url is not found within: "+timeOut);
			}
			return null;
		}
		
		public String waitForUrlIs(String Url, int timeOut) {
			WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.urlToBe(Url));
				return driver.getCurrentUrl();
			}
			catch(Exception e) {
				System.out.println("url is not found within: "+timeOut);
			}
			return null;
		}
		
		public Alert waitForJSAlertWithFluentWait(int timeOut, int pollingTime) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(timeOut))
									.pollingEvery(Duration.ofSeconds(pollingTime))
									.ignoring(NoAlertPresentException.class)
									.withMessage(DEFAULT_ALERT_TIME_OUT_MESSAGE);
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public Alert waitForJSAlert(int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public String getAlertText(int timeOut) {
			return waitForJSAlert(timeOut).getText();
		}
		
		public void acceptAlert(int timeOut) {
			waitForJSAlert(timeOut).accept();
		}
		
		public void dismissAlert(int timeOut) {
			waitForJSAlert(timeOut).dismiss();
		}
		
		public void alertSendKeys(int timeOut, String value) {
			waitForJSAlert(timeOut).sendKeys(value);
		}
		
		public boolean waitForWindow(int totalNumberOfWindowsToBe, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.numberOfWindowsToBe(totalNumberOfWindowsToBe));
		}
		
		public void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		}
		
		public void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		}
		
		
		public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		}
		
		//Custom Wait using default 500ms interval time   --- INTERVIEW
		public WebElement retryingElement(By locator, int timeOut) {

			WebElement element = null;
			int attempts = 0;

			while (attempts < timeOut) {

				try {
					element = getElement(locator);
					System.out.println("element is found...." + locator + " in attempt " + attempts);
					break;
				} catch (NoSuchElementException e) {
					System.out.println("element is not found.... " + " in attempts " + attempts);
					TimeUtil.defaultTime();
				}
				attempts++;
			}
			
			if(element == null) {
				System.out.println("element is not found.....tried for " + timeOut + " times " + " with the interval of " + 500 + " milliseconds..." );
				throw new MyElementException("No Such Element");
			}
			return element;

		}
		
		//Custom Wait using interval time   --- INTERVIEW
		public WebElement retryingElement(By locator, int timeOut, int intervalTime) {

			WebElement element = null;
			int attempts = 0;

			while (attempts < timeOut) {

				try {
					element = getElement(locator);
					System.out.println("element is found...." + locator + " in attempt " + attempts);
					break;
				} catch (NoSuchElementException e) {
					System.out.println("element is not found.... " + " in attempts " + attempts);
					TimeUtil.applyWait(intervalTime);
				}
				attempts++;

			}
			
			if(element == null) {
				System.out.println("element is not found.....tried for " + timeOut + " times " + " with the interval of " + intervalTime + " seconds..." );
				throw new MyElementException("No Such Element");
			}
			return element;

		}

}
