package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionWIthSelectClass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple");

		WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		
		Select select = new Select(dropDownEle);
		
		System.out.println(select.isMultiple());
		
		if(select.isMultiple()) {
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Greater flamingo");
			select.selectByVisibleText("Lesser flamingo");
		}
		
//		select.deselectByVisibleText("Chilean flamingo");
//		select.deselectByIndex(0);
//		select.deselectAll();
		
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("------------------------------------");
		
		List<WebElement> selectedOptionsList = select.getAllSelectedOptions();
		for(WebElement e : selectedOptionsList) {
			
			System.out.println(e.getText());
		}
		
		
		
	}

}
