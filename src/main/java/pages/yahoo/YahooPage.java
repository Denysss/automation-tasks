package pages.yahoo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.PageTemplate;
import pages.helpers.SeleniumActions;

public class YahooPage extends PageTemplate {

	private final String urlMainPage = "https://www.yahoo.com/";
	// private final By links = By.cssSelector("#Navigation > a");
	private final By links = By.xpath("//div[@id='Navigation']//a");

	public YahooPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		open(urlMainPage);
	}

	public void open(String url) {
		setUpPage(url);
		driver.manage().timeouts().pageLoadTimeout(SeleniumActions.DEFAULT_PAGE_TIMEOUT, TimeUnit.SECONDS);
		// println(getTitle());
	}

	public List<String> getYahooSites() {
		List<String> listYahooSites = getLinks(links);
		return listYahooSites;
	}

	public String getUrlMainPage() {
		return urlMainPage;
	}
}