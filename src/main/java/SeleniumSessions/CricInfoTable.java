package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/women-s-premier-league-2023-24-1411373/delhi-capitals-women-vs-up-warriorz-women-4th-match-1417719/full-scorecard");

//		String name = "Tahlia McGrath";
//		System.out.println(
//				"Batsman: " + name + ", Bowler: " + getWicketTaker(name) + ", ScoreCard: " + getScoreCard(name));

//		String name1 = "Poonam Khemnar";		
//		System.out.println(
//				"Batsman: " + name1 + ", Bowler: " + getWicketTaker(name1) + ", ScoreCard: " + getScoreCard(name1));

//		System.out.println(getWicketTaker(name));

//		getAllScoreCard();
		
		ArrayList<ArrayList<String>> playersScoreCard = getPlayersScoreCard("Tahlia McGrath","Poonam Khemnar");
		for (ArrayList<String> batsman : playersScoreCard) {
			System.out.println(batsman);
		}
		
		
		
		
	}

	// Methods:
	// WicketTaker Name
	public static String getWicketTaker(String Batsman) {
		return driver
				.findElement(By.xpath("(//span[text()='" + Batsman + "'])[1]/ancestor::td/following-sibling::td/span"))
				.getText();
	}

	// ScoreCard of a Specific Player
	public static ArrayList<String> getScoreCard(String Batsman) {
		List<WebElement> scoreCardList = driver
				.findElements(By.xpath("(//span[text()='" + Batsman + "'])[1]/ancestor::td/following-sibling::td"));
		ArrayList<String> scoreCard = new ArrayList<String>();

		for (WebElement s : scoreCardList) {
			String scoreCardText = s.getText();
			scoreCard.add(scoreCardText);
		}
//		scoreCard.remove(0);         //to remove bowler info from the arraylist
		return scoreCard;
	}

	// ScoreCard of a Specific Player using dot parameter
	public static ArrayList<ArrayList<String>>  getPlayersScoreCard(String... Batsman) {
		ArrayList<String> scoreCard = new ArrayList<String>();
		ArrayList<ArrayList<String>> finalscoreCard = new ArrayList<ArrayList<String>>();


		for (String b : Batsman) {
			scoreCard = new ArrayList<String>();
			scoreCard.add(b);
			List<WebElement> scoreCardList = driver
					.findElements(By.xpath("(//span[text()='" + b + "'])[1]/ancestor::td/following-sibling::td"));
			for (WebElement s : scoreCardList) {
				String scoreCardText = s.getText();
				scoreCard.add(scoreCardText);
			}
			finalscoreCard.add(scoreCard);

		}
	
//			scoreCard.remove(0);         //to remove bowler info from the arraylist
		return finalscoreCard;
	}

	// List of All Players and their ScoreCards
	public static void getAllScoreCard() {
		List<WebElement> rows = driver
				.findElements(By.xpath("(//table[contains(@class,'ci-scorecard-table')]//tr[@class=''])//a"));

		int rowsCount = driver
				.findElements(By.xpath("(//table[contains(@class,'ci-scorecard-table')]//tr[@class=''])//a")).size();

		System.out.println("Number of Batsman: " + rowsCount);

		for (WebElement r : rows) {
			String rowText = r.getText();
			if (rowText.endsWith("(c)†")) {
				rowText = rowText.substring(0, rowText.length() - 4);
			} else if (rowText.endsWith("(c)")) {
				rowText = rowText.substring(0, rowText.length() - 3);
			}

			List<WebElement> scoreCardList = driver.findElements(
					By.xpath("(//span[text()='" + rowText.trim() + "'])[1]/ancestor::td/following-sibling::td"));
			ArrayList<String> scoreCard = new ArrayList<String>();

			for (WebElement s : scoreCardList) {
				String scoreCardText = s.getText();
				scoreCard.add(scoreCardText);
			}
			System.out.println(rowText + " - " + scoreCard);
			scoreCard.clear();
		}

	}

}
