package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPage {
	private static Logger logger = LoggerFactory.getLogger(OrderPage.class);
	WebDriver driver;
	
	public void orderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//div[@id='centercolumn']/p[2]/a[1]")WebElement proceedToCheckoutButton;
	@FindBy(how = How.XPATH, using = "//div[@id='centercolumn']/form/p/button")WebElement proceedToCheckoutButtonAddressPage;
	@FindBy(how = How.XPATH, using = "//form[@id='form']/p/button")WebElement proceedToCheckoutButtonShippingPage;
	@FindBy(how = How.XPATH, using = "//input[@id='cgv']")WebElement checkBoxAgreeToTermsShippingPage;
	@FindBy(how = How.XPATH, using = "//a[@class='bankwire']")WebElement payByBankWirePaymentPage;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")WebElement iConfirmMyOrderPaymentPage;
	@FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")WebElement myAccountButton;
	@FindBy(how = How.XPATH, using = "//p[@class='cheque-indent']/strong[@class='dark']")WebElement orderConfirmation;
	
	
	//InteractiveMethods
	public void clickProceedToCheckout() {
		proceedToCheckoutButton.click();
	}

	public void clickProceedToCheckoutAddressPage() {
		proceedToCheckoutButtonAddressPage.click();
	}

	public void clickProceedToCheckoutShippingPage() {
		proceedToCheckoutButtonShippingPage.click();
	}

	public void clickCheckBoxAgreeToTermsShippingPage() {
		checkBoxAgreeToTermsShippingPage.click();
	}

	public void clickPayByBankWirePaymentPage() {
		payByBankWirePaymentPage.click();
	}

	public void clickIConfirmMyOrderPage() {
		iConfirmMyOrderPaymentPage.click();
	}
	
	public void clickMyAccountButton() {
		myAccountButton.click();
	}
	
	public void assertOrderConfirmation() {
		
		if(orderConfirmation.getText().contains("complete")) {
			logger.info("Order Verified");
		}else {
			logger.warn("Order not completed");
		}
		
	}
	


}
