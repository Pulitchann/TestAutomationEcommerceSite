package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sign in')]")
	WebElement signinButton;
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	WebElement womenButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"blocktopmenu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tshirtsButton;
	@FindBy(how = How.XPATH, using = "//div/a[@title='Contact Us']")
	WebElement contactUsButton;

	// InteractiveMethods
	public void clickOnSignInButton() {
		signinButton.click();
	}
	
	public void hoverOverWomenButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(womenButton).perform();
	}

	public void clickTshirtsButton() {
		tshirtsButton.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickContactUSButton() {
		contactUsButton.click();
	}

}
