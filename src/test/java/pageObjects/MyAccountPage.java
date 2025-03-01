package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutBtn;
	
	public boolean isMyAccountPageExists() {
		try {
			return (MyAccount.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	} 
	
	public void clickLogout() {
		logoutBtn.click();
	}

}
