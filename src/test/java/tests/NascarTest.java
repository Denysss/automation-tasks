package tests;

import static org.junit.Assert.*;

import org.joda.time.LocalTime;
import org.junit.Test;

import pages.nascar.NascarLoginDialog;
import pages.nascar.NascarMainPage;
import pages.nascar.NascarRegistrationDialog;
import tests.templates.TestTemplate;

/**
 * 
 * Automate following steps: Goto www.nascar.com Register Login with the
 * registered credentials Logout
 *
 */

public class NascarTest extends TestTemplate {

	private NascarMainPage nascarPage;

	@Test
	public void loginByRegisteredUser() {
		// test data
		String registeredUserEmail = "shynkarenkoden@yandex.ru";
		String registeredUserPassword = "Denys123456789";

		openNascarMainPage();
		login(registeredUserEmail, registeredUserPassword);
		logOutFromNascarMainPage();
	}

	@Test
	public void registerNewUser() {
		// test data
		String newUser = "test";
		String newUserEmail = "@test.ua";
		String newUserPassword;
		String newUserZip = "40211";
		boolean privacyPolicyOfNewUserName = true;

		// prepare test data
		String now = LocalTime.now().toString("HHmmssSSS");
		newUserEmail = newUser + now + newUserEmail;
		newUserPassword = newUser + now;

		openNascarMainPage();
		register(newUserEmail, newUserPassword, newUserZip, privacyPolicyOfNewUserName);
		logOutFromNascarMainPage();
	}

	private void openNascarMainPage() {
		nascarPage = new NascarMainPage(driver);
		nascarPage.open();
	}

	private void logOutFromNascarMainPage() {
		nascarPage.clickOnMyProfile();
		nascarPage.clickOnLogOut();
	}

	private void login(String email, String password) {
		NascarLoginDialog loginDialog = nascarPage.clickOnLogin();

		loginDialog.setUserName(email);
		loginDialog.setPassword(password);
		loginDialog.submit();
	}

	private void register(String email, String password, String zip, boolean privacyPolicy) {
		NascarRegistrationDialog registerDialog = nascarPage.clickOnRegister();

		registerDialog.setUserName(email);
		registerDialog.setPassword(password);
		registerDialog.setZipCode(zip);
		registerDialog.setPrivacyPolicy(privacyPolicy);
		registerDialog.submit();
	}
}
