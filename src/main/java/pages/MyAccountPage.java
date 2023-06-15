package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage {
	private static Logger logger = LoggerFactory.getLogger(MyAccountPage.class);
	
	WebDriver driver;

	public void myAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	//Element Library
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	WebElement womenButton;
	@FindBy(how = How.XPATH, using = "//*[@id='blocktopmenu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tshirtsButton;
	@FindBy(how = How.XPATH, using = "//*[@id='centercolumn']/div/div[1]/ul/li[1]/a")
	WebElement orderHistoryAndDetailsButton;
	@FindBy(how = How.XPATH, using = "//a[@class='account']/span")
	WebElement nameOnAccount;

	//InteractiveMethods
	public void hoverOverWomenButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(womenButton).perform();
	}

	public void clickTshirtsButton() {
		tshirtsButton.click();
	}

	public void clickOrderHistoryAndDetailsButton() {
		orderHistoryAndDetailsButton.click();
	}
	
	public void assertNameOnAccount(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		logger.info(fullName);
	}
}
