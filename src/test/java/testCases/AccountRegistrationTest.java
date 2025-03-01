package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {

	@Test(groups = "regression")
	public void verify_account_registration() {

		logger.info("**** Starting verify_account_registration ****");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage acc = new AccountRegistrationPage(driver);
			acc.setFirstName(randomString());
			acc.setLastName(randomString());
			acc.setEmail(randomString() + "@gmail.com");
			acc.setPassword(randomNumber());
			acc.setPolicyCheckbox();
			acc.clickContinueButton();

			logger.info("Validating Expected message..");
			String confirmMsg = acc.getConfirmatiomMsg();
			if (confirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}

			//Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**** Finished verify_account_registration ****");
	}

}
