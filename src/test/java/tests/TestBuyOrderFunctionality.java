package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.OrderPage;
import pages.ProductPage;
import pages.TshirtsPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate End to End Buy Order functionality.

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.*/

public class TestBuyOrderFunctionality {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	// The actual Test
	@Test
	public void TestBuyOrderFunctionality() throws InterruptedException {
		
		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String username = reader.getCellData("LoginInfo", "username", 2);
		String password = reader.getCellData("LoginInfo", "password", 2);

		MainPage mainP = PageFactory.initElements(driver, MainPage.class);
		mainP.clickOnSignInButton();

		// 2. Login to the website.
		LoginPage loginP = PageFactory.initElements(driver, LoginPage.class);
		loginP.enterEMailAddress(username);
		loginP.enterPassword(password);
		loginP.clickSigninButton();

		MyAccountPage myAcc = PageFactory.initElements(driver, MyAccountPage.class);
		// 3. Move your cursor over Women's link.
		myAcc.hoverOverWomenButton();
		// 4. Click on sub menu 'T-shirts'.
		myAcc.clickTshirtsButton();

		TshirtsPage ts = PageFactory.initElements(driver, TshirtsPage.class);
		// 5. Mouse hover on the first product displayed.
		ts.hoverOverProduct();
		// 6. 'More' button will be displayed, click on 'More' button.
		ts.clickMoreButtonProductOne();

		ProductPage prodP = PageFactory.initElements(driver, ProductPage.class);
		// 7. Increase quantity to 2.
		prodP.enterQuantity("2");
		// 8. Select size 'L'
		prodP.selectSize("L");
		// 9. Select color.
		prodP.selectColor();
		// 10. Click 'Add to Cart' button.
		prodP.clickAddToCartButton();
		// 11. Click 'Proceed to checkout' button.
		prodP.clickProceedToCheckoutButton();

		// 12. Complete the buy order process till payment.
		OrderPage orderP = PageFactory.initElements(driver, OrderPage.class);
		orderP.clickProceedToCheckout();
		orderP.clickProceedToCheckoutAddressPage();
		orderP.clickCheckBoxAgreeToTermsShippingPage();
		orderP.clickProceedToCheckoutShippingPage();
		orderP.clickPayByBankWirePaymentPage();
		orderP.clickIConfirmMyOrderPage();
		// 13. Make sure that Product is ordered.
		orderP.assertOrderConfirmation();

	}

	// Closing browser
	@AfterMethod
	public void closeBrowser() {
		BrowserFactory.closeBrowser();
	}

}