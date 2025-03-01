package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "sanity") //Getting data provider from different
																				// package
	public void Verify_login(String email, String pass, String exp) {
		try {

			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmailAddress(email);
			lp.enterPass(pass);
			lp.clickLogin();

			MyAccountPage acc = new MyAccountPage(driver);
			boolean targetPage = acc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					acc.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					acc.clickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
