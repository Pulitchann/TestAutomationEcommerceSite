package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Verify error messages for mandatory fields.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter email address and click Register button.
4. Leave the mandatory fields (marked with *) blank and click Register button.
5. Verify that error has been displayed for the mandatory fields.*/

public class TestVerifyErrorMessagesForMandatoryFields {

	WebDriver driver;

	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	@Test
	public void TestVerifyErrorMessagesForMandatoryFields() {
		MainPage mainp = PageFactory.initElements(driver, MainPage.class);
		mainp.clickOnSignInButton();

		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		loginp.fillCreatAccountEmailField();
		loginp.clickCreateAnAccountButton();

		CreateAnAccountPage createaccp = PageFactory.initElements(driver, CreateAnAccountPage.class);
		createaccp.clickRegisterButton();
		createaccp.verifyErrorAlertForMandatoryFields();

	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.closeBrowser();
	}

}
