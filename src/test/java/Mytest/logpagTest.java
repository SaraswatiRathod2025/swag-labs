package Mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Handlebrowser;
import Mylocator.HomLoc;
import Mylocator.LogLoc;

public class logpagTest extends Handlebrowser {
	@Test(description = "varify the title of sauce Demo project page")
	public void variyfyTitle() throws InterruptedException {
		// System.out.println("my first test case");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Swag Labs");// lang.AssertionError: expected [Swag Labs!] but found [Swag Labs]
	}

	@Test(description = "Varify the login page with valid credential")
	public void VarifySuccesssfullLogin() {
	
		LogLoc lg = new LogLoc(driver);// constructor
		lg.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));

	HomLoc hp = new HomLoc(driver);
  System.out.println("print :"+hp.isMenuDispayed());
		
	
	Assert.assertTrue(hp.isMenuDispayed());
	}	
	/*@Test(description = "Verify error message when user enters invalid credentials", dataProvider = "InvalidCredentialsTestData", dataProviderClass=Utilities.TestData.class)
		public void verifyInvalidCredentials(String username, String password) {
		Logloc lg = new Logloc(driver);
			lg.enterCredentials(username, password);
		
		String actualErrorMsg= lg.fetchErrorMessage();
	Assert.assertEquals(actualErrorMsg,"Epic sadface: Username and password do not match any user in this service");*/
		
}


