package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Automate first Menu link and print page title

Steps to Automate:
1. Launch browser
2. Open URL
3. Maximize or set size of browser window.
4. Get the page title and print it.
5. Now, click on first menu link say "Contact us"
6. Get the page title and print it.
7. Navigate back to Home Page.
8. Get the page title and print it. Verify that value matches with output of point no. 4
9. Close the browser.*/

public class TestClickFirstMenuLinkAndPrintPageTitle {
	WebDriver driver;

	/*
	 * 1. Launch browser 2. Open URL 3. Maximize or set size of browser window.
	 */
	//Starting Browser
	@BeforeMethod
	public void startBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	//the actual test
	@Test
	public void TestclickFirstMenuLinkAndPrintPageTitle() {

		MainPage mainP = PageFactory.initElements(driver, MainPage.class);
		// 4. Get the page title and print it.
		String mainPageTitle = mainP.getPageTitle();
		System.out.println(mainPageTitle);

		// 5. Now, click on first menu link say "Contact us"
		mainP.clickContactUSButton();

		// 6. Get the page title and print it.
		ContactUsPage contactus = PageFactory.initElements(driver, ContactUsPage.class);
		String contactUsPageTitle = contactus.getPageTitle();
		System.out.println(contactUsPageTitle);
		// 7. Navigate back to Home Page.
		driver.navigate().back();

		// 8. Get the page title and print it. Verify that value matches with output of
		// point no. 4
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(mainPageTitle)) {
			System.out.println("Success! The page title we got matches the Main Page title");
		} else {
			System.out.println("Failure, The page title we got does not matche the Main Page title ");
		}
	}

	// 9. Close the browser.
	// Closing browser
	@AfterMethod
	public void closeBrowser() {
		BrowserFactory.closeBrowser();
	}

}
