package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TshirtsPage;
import util.BrowserFactory;

/*Test Case - Verify that 'Add to Wishlist' only works after login.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Move your cursor over Women's link.
3. Click on sub menu 'T-shirts'.
4. Mouse hover on the second product displayed.
5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
6. Verify that error message is displayed 'You must be logged in to manage your wishlist.'*/

public class TestWishListWorksAfterLogin {
	WebDriver driver;

	//1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	@Test
	public void TestWishListWorksAfterLohin() throws InterruptedException {

		MainPage mainP = PageFactory.initElements(driver, MainPage.class);
		// 2. Move your cursor over Women's link.
		mainP.hoverOverWomenButton();
		// 3. Click on sub menu 'T-shirts'.
		mainP.clickTshirtsButton();

		TshirtsPage ts = PageFactory.initElements(driver, TshirtsPage.class);
		// 4. Mouse hover on the second product displayed.
		ts.hoverOverProduct();
		// 5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
		ts.clickwishlistProduct();
		//6. Verify that error message is displayed
		ts.verifywishlistErrorBox();

		
	}

	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.closeBrowser();
	}
}
