package pages.nascar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageTemplate;

public class NascarRegistrationDialog extends PageTemplate {

	private final By dialog = By.cssSelector("div[class|='gigya-screen-dialog'][style~='visibility: visible']");

	private final By divLiteRegHead = dialog.className("lite-reg-head");
	private final By textEmail = dialog.name("email");
	private final By password = dialog.name("password");
	private final By textZIP = dialog.name("zip");
	private final By checkboxPrivacyPolicy = dialog.name("data.terms");
	private final By submit = dialog.className("gigya-input-submit");

	public NascarRegistrationDialog(WebDriver driver) {
		super(driver);
		waitUntilElementAppear(divLiteRegHead);
		println(getText(divLiteRegHead));
	}

	public void setUserName(String userName) {
		sendKey(textEmail, userName);
	}

	public void setPassword(String pass) {
		sendKey(password, pass);
	}

	public void setZipCode(String zip) {
		sendKey(textZIP, zip);
	}

	public void setPrivacyPolicy(boolean currentState) {
		if (currentState != isSelected(checkboxPrivacyPolicy))
			click(checkboxPrivacyPolicy);
	}

	public void submit() {
		click(submit);
		waitUntilElementDisappear(divLiteRegHead);
	}

}
