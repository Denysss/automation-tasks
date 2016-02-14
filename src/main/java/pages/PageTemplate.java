package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.helpers.SeleniumActions;

public abstract class PageTemplate {

	protected final WebDriver driver;
	protected WebDriverWait driverWait;

	protected PageTemplate(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, SeleniumActions.DEFAULT_ELEMENT_TIMEOUT);
	}

	protected void setUpPage(String link) {
		SeleniumActions.setUpPage(driver, link);
	}

	protected void sendKey(By locator, String value) {
		SeleniumActions.sendKey(driver, locator, value);
	}

	protected void clear(By locator) {
		SeleniumActions.clear(driver, locator);
	}

	protected void submit(By locator) {
		SeleniumActions.submit(driver, locator);
	}

	protected void click(By locator) {
		SeleniumActions.click(driver, locator);
	}

	protected Boolean isSelected(By locator) {
		return SeleniumActions.isSelected(driver, locator);
	}

	protected String getText(By locator) {
		SeleniumActions.waitOnElementWithUnEmptyText(driver, locator);
		return SeleniumActions.getText(driver, locator);
	}

	protected String getTitle() {
		return SeleniumActions.getTitle(driver);
	}

	protected List<String> getLinks(By locator) {
		String href;
		List<String> linkList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(locator);

		for (WebElement element : elementList) {
			href = element.getAttribute("href");
			if (!linkList.contains(href))
				linkList.add(href);
		}

		return linkList;
	}

	protected void waitUntilElementDisappear(By locator) {
		driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitUntilElementAppear(By locator) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void println(String str) {
		System.out.println(str);
	}
}