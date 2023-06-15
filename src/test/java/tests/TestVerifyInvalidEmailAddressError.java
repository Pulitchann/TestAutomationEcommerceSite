package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Verify invalid email address error.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter invalid email address in the email box and click enter.
4. Validate that an error message is displaying saying "Invalid email address."*/

public class TestVerifyInvalidEmailAddressError {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	@Test
	public void TestVerifyInvalidEmailAddressError() {
		MainPage mainp = PageFactory.initElements(driver, MainPage.class);
		// 2. Click on sign in link.
		mainp.clickOnSignInButton();

		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		// 3. Enter invalid email address in the email box and click enter.
		loginp.fillCreatAccountWithInvalidEmailField("useremail@yxz");
		loginp.clickCreateAnAccountButton();
		// 4. Validate that an error message is displaying saying "Invalid email
		// address".
		loginp.verifyCreatAccountWithInvalidEmailField();
	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.closeBrowser();
	}

}
