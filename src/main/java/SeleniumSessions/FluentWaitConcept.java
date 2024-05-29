package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	public static void main(String[] args) {

		// Wait(I) : until(); --> FluentWait(C): until(){} + other methods -->
		// WebDriverWait (C)

		WebDriver driver = new ChromeDriver();// browser - chrome

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");// page

		By image = By.cssSelector("div#imageTemplateContainer img");

		// Fluent Wait:
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(10))
								.pollingEvery(Duration.ofSeconds(2))
								.ignoring(NoSuchElementException.class)
								.withMessage("Time out... Element not present");

		WebElement image_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(image));
		image_ele.click();

		// Can have multiple Fluent wait for multiple exceptions:
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(10))
								.pollingEvery(Duration.ofSeconds(2))
								.ignoring(NoAlertPresentException.class)
								.withMessage("Time out... alert is not present");

		// WEBDriverWait with FluentWait Features:
//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//					wait.pollingEvery(Duration.ofSeconds(2))
//						.ignoring(NoSuchElementException.class)
//						.withMessage("time out...element is not present...");
//					
//					WebElement image_ele = 
//							wait.until(ExpectedConditions.visibilityOfElementLocated(image));
		//
//					image_ele.click();

	}

}
