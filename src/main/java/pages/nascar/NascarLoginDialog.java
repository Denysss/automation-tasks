package pages.nascar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageTemplate;

public class NascarLoginDialog extends PageTemplate {

	private final By dialog = By.cssSelector("div[class|='gigya-screen-dialog'][style~='visibility: visible']");

	private final By divLiteRegHead = dialog.className("lite-reg-head");
	private final By textEmail = dialog.name("username");
	private final By password = dialog.name("password");
	private final By submit = dialog.className("gigya-input-submit");

	public NascarLoginDialog(WebDriver driver) {
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

	public void submit() {
		click(submit);
		waitUntilElementDisappear(divLiteRegHead);
	}
}
