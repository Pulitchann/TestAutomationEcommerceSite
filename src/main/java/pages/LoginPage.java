package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage{
	
	private static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	WebDriver driver;
	
	public void loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement emailAddressField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement createAnAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='emailcreate']") WebElement creatAccountEmailField;
	@FindBy(how = How.XPATH, using = "//*[@id='createaccounterror']") WebElement invalidEmailAlert;
	@FindBy(how = How.XPATH, using = "//div[@id='createaccounterror']/ol/li") WebElement invalidEmailAlertText;
	
	//InteractiveMethods
	public void enterEMailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickSigninButton() {
		signInButton.click();
	}
	
	public void clickCreateAnAccountButton() {
		createAnAccountButton.click();
	}
	
	public void fillCreatAccountEmailField() {
		creatAccountEmailField.sendKeys(randomNumberGenerator() + "." + randomNumberGenerator() + "user@email.com");
	}

	public void fillCreatAccountWithInvalidEmailField(String email) {
		creatAccountEmailField.sendKeys(email);
	}

	public void verifyCreatAccountWithInvalidEmailField() {
		
		if(invalidEmailAlertText.isDisplayed() == true) {
			logger.info("Success! Alert for invalid email was displayed");
			logger.warn(invalidEmailAlertText.getText());
		}else {
			logger.error("Failure, alert for invalid email was not displayed ");
		}
		
	}
}
