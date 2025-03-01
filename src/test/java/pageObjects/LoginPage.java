package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddr;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;

	public void enterEmailAddress(String email) {
		txtEmailAddr.sendKeys(email);
	}

	public void enterPass(String password) {
		txtEmailAddr.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

}
