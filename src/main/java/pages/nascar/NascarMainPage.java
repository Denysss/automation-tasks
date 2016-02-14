package pages.nascar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.PageTemplate;

public class NascarMainPage extends PageTemplate {

	private final String urlMainPage = "http://www.nascar.com/en_us/sprint-cup-series.html";

	private final By divRightSection = By.className("global-nav-second-right");
	private final By hrefMyProfile = divRightSection.id("myProfileLink");
	private final By hrefLogin = divRightSection.cssSelector("a[class|='gigyaLoginDialog']");
	private final By hrefRegister = divRightSection.cssSelector("a[class|='gigyaRegisterDialog']");

	private final By buttonLogOut = By
			.cssSelector("input[class='gigya-input-submit logout'][data-screenset-roles='instance']");

	public NascarMainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		setUpPage(urlMainPage);
		waitUntilElementAppear(divRightSection);
		System.out.println(getTitle());
	}

	public NascarLoginDialog clickOnLogin() {
		waitUntilElementAppear(hrefLogin);
		click(hrefLogin);
		return new NascarLoginDialog(driver);
	}

	public NascarRegistrationDialog clickOnRegister() {
		waitUntilElementAppear(hrefRegister);
		click(hrefRegister);
		return new NascarRegistrationDialog(driver);
	}

	public void clickOnMyProfile() {
		waitUntilElementAppear(hrefMyProfile);
		click(hrefMyProfile);
	}

	public void clickOnLogOut() {
		waitUntilElementAppear(buttonLogOut);
		click(buttonLogOut);
	}
}
