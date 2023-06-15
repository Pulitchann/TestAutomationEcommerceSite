package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage extends BasePage {
	private static Logger logger = LoggerFactory.getLogger(ProductPage.class);
	WebDriver driver;
	double dblCurrentTotal;

	public void productPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='quantitywanted']")
	WebElement quantityWanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group1']")
	WebElement sizeSelection;
	@FindBy(how = How.XPATH, using = "//a[@id='color14']")
	WebElement selectColor;
	@FindBy(how = How.XPATH, using = "//p[@id='addtocart']/button")
	WebElement addToCartButton;
	@FindBy(how = How.XPATH, using = "//*[@id='layercart']/div[1]/div[2]/div[4]/a")
	WebElement proceedToCheckoutButton;
	@FindBy(how = How.XPATH, using = "//a[@class='cartquantityup btn btn-default button-plus']")
	WebElement increaseQuantityButton;
	@FindBy(how = How.XPATH, using = "//td[@class='carttotal']//span")
	WebElement totalProductPrice;
	@FindBy(how = How.XPATH, using = "//td[@data-title='Unit price']//span//span")
	WebElement productPrice;

	// InteractiveMethods
	public void enterQuantity(String quantity) {
		quantityWanted.clear();
		quantityWanted.sendKeys(quantity);
	}

	public void selectSize(String size) {
		selectFromDropdownByVisibleText(sizeSelection, size);
	}

	public void selectColor() {
		selectColor.click();
	}

	public void clickAddToCartButton() {
		addToCartButton.click();
	}

	public void clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}

	public void clickIncreaseQuantityButton() {
		increaseQuantityButton.click();
	}

	public void testTotalCalculation() throws InterruptedException {

		dblCurrentTotal = convertStringToDouble(totalProductPrice);
		
		clickIncreaseQuantityButton();
		
		double dblProductPrc = convertStringToDouble(productPrice);

		Thread.sleep(2000);

		double dblModifiedTotal = convertStringToDouble(totalProductPrice);
		
		if (dblCurrentTotal + dblProductPrc == dblModifiedTotal) {
			logger.info("Success! the calculation is correct");
		} else {
			logger.warn("Failure, the calculation is wrong");
		}
	}

}
