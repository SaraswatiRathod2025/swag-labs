package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;



import Base.Handlebrowser;
import Locator.Homepage;
import Locator.LoginPageLocator;

public class Loginpage extends Handlebrowser {
	@Test(description = "varify the title of sauce Demo project page")
	public void variyfyTitle() throws InterruptedException {
		// System.out.println("my first test case");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Swag Labs");// lang.AssertionError: expected [Swag Labs!] but found [Swag Labs]
	}

	@Test(description = "Varify the login page with valid credential")
	public void VarifySuccesssfullLogin() {
		LoginPageLocator loginpagelocators = new LoginPageLocator(driver);// constructor
		loginpagelocators.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));

		
		Homepage homepage = new Homepage(driver);
		// Assert.assertEquals(homePageLocaters.isMenuDispayed(), true);
		Assert.assertTrue(homepage.isMenuDispayed());
	}
	
	@Test(description = "Verify error message when user enters invalid credentials", dataProvider = "InvalidCredentialsTestData", dataProviderClass=Utilities.Testdata.class)
	public void verifyInvalidCredentials(String username, String password) {
		LoginPageLocator loginPageLocaters = new LoginPageLocator(driver);
		loginPageLocaters.enterCredentials(username, password);

		String actualErrorMsg = loginPageLocaters.fetchErrorMessage();
		Assert.assertEquals(actualErrorMsg,"Epic sadface: Username and password do not match any user in this service");
		
		
	}


}
