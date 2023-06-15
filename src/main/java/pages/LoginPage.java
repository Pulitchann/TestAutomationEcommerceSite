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
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement Email_Address_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement SignIn_Button;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement CreateAnAccount_Button;
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']") WebElement CreatAccountEmail_Field;
	@FindBy(how = How.XPATH, using = "//*[@id='create_account_error']") WebElement InvalidEmail_Alert;
	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']/ol/li") WebElement InvalidEmail_Alert_Text;
	
	//InteractiveMethods
	public void Enter_EMail_Address(String Email) {
		Email_Address_Field.sendKeys(Email);
	}
	
	public void Enter_Password(String Password) {
		Password_Field.sendKeys(Password);
	}
	
	public void Click_Signin_Button() {
		SignIn_Button.click();
	}
	
	public void Click_CreateAnAccount_Button() {
		CreateAnAccount_Button.click();
	}
	
	public void Fill_CreatAccountEmail_Field() {
		CreatAccountEmail_Field.sendKeys(Random_Number_Generator() + "." + Random_Number_Generator() + "user@email.com");
	}

	public void Fill_CreatAccount_WithInvalidEmail_Field(String email) {
		CreatAccountEmail_Field.sendKeys(email);
	}

	public void Verify_CreatAccount_WithInvalidEmail_Field() {
		
		if(InvalidEmail_Alert_Text.isDisplayed() == true) {
			logger.info("Success! Alert for invalid email was displayed");
			logger.warn(InvalidEmail_Alert_Text.getText());
		}else {
			logger.error("Failure, alert for invalid email was not displayed ");
		}
		
	}
}
