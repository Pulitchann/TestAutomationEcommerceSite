package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate User Registration Process

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.*/

public class TestUserRegistrationProcess {
	WebDriver driver;

	// 1. Open this url http://automationpractice.com/index.php
	// 2. Click on sign in link.
	// Starting browser and navigating to website
	@BeforeMethod
	public void startBrowser() {
		driver = BrowserFactory.launchBrowser();
	}

	@Test
	public void TestUserRegistrationProcess() {

		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String firstName = reader.getCellData("Sheet3", "FirstName", 2);
		String lastName = reader.getCellData("Sheet3", "LastName", 2);
		String password = reader.getCellData("Sheet3", "Password", 2);
		String day = reader.getCellData("Sheet3", "day", 2);
		String month = reader.getCellData("Sheet3", "month", 2);
		String year = reader.getCellData("Sheet3", "year", 2);
		String company = reader.getCellData("Sheet3", "Company", 2);
		String address = reader.getCellData("Sheet3", "Address", 2);
		String city = reader.getCellData("Sheet3", "City", 2);
		String state = reader.getCellData("Sheet3", "State", 2);
		String zipCode = reader.getCellData("Sheet3", "ZipCode", 2);
		String country = reader.getCellData("Sheet3", "Country", 2);
		String alias = reader.getCellData("Sheet3", "alias", 2);

		MainPage mainP = PageFactory.initElements(driver, MainPage.class);
		mainP.clickOnSignInButton();

		LoginPage loginP = PageFactory.initElements(driver, LoginPage.class);
		// 3. Enter your email address in 'Create and account' section.
		loginP.fillCreatAccountEmailField();
		// 4. Click on Create an Account button.
		loginP.clickCreateAnAccountButton();

		CreateAnAccountPage createAcc = PageFactory.initElements(driver, CreateAnAccountPage.class);
		// 5. Enter your Personal Information, Address and Contact info.
		createAcc.clickMrRadioButton();
		createAcc.fillFirstNameField(firstName);
		createAcc.fillLastNameField(lastName);
		createAcc.fillPasswordField(password);
		createAcc.selectDaySelection(day);
		createAcc.selectMonthSelection(month);
		createAcc.selectYearSelection(year);
		createAcc.clickNewsletterCheckBox();
		createAcc.clickSpecialOfferCheckBox();
		createAcc.fillAddressCompanyField(company);
		createAcc.fillAddress1Field(address);
		createAcc.fillCityField(city);
		createAcc.selectStateField(state);
		createAcc.fillZipCodeField(zipCode);
		createAcc.selectCountryField(country);
		createAcc.fillCellPhoneField();
		createAcc.fillAliasAddressField(alias);
		// 6. Click on Register button.
		createAcc.clickRegisterButton();

		// 7. Validate that user is created.
		MyAccountPage myAccP = PageFactory.initElements(driver, MyAccountPage.class);
		myAccP.assertNameOnAccount(firstName, lastName);
	}

	// Closing browser
	@AfterMethod
	public void closeBrowser() {
		BrowserFactory.closeBrowser();
	}
}
