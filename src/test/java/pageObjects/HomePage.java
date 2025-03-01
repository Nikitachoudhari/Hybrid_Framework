package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountButton;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement RegisterOption;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement LoginOption;

	public void clickMyAccount() {
		MyAccountButton.click();
	}

	public void clickRegister() {
		RegisterOption.click();
	}

	public void clickLogin() {
		LoginOption.click();
	}
}
