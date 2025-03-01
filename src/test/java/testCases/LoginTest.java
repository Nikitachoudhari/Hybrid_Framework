package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	@Test(groups={"regression" , "master"})
	public void Verify_login() {
		try {

			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmailAddress(p.getProperty("email"));
			lp.enterPass(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage acc = new MyAccountPage(driver);
			boolean targetPage = acc.isMyAccountPageExists();

			Assert.assertTrue(targetPage);

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
