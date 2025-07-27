package Testcase;

import java.util.Map;

import org.testng.annotations.Test;


import org.openqa.selenium.Alert;
import org.testng.Assert;


import Base.Handlebrowser;
import Locator.Homepage;
import Locator.LoginPageLocator;

public class HomepageTest extends Handlebrowser {
	@Test(description = "varify the product")
	public void VarifyProcessingOfItem() {
		LoginPageLocator loginpagelocators = new LoginPageLocator(driver);// constructor
		loginpagelocators.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		
		Homepage homepage = new Homepage(driver);
		
		Assert.assertTrue(homepage.isMenuDispayed());


	homepage.SelectOneproduct("Test.allTheThings() T-Shirt (Red)");
	 String Indetailprice=homepage.AddproducttoCart();
	 Indetailprice="Item total:"+Indetailprice;
	 float invprice= homepage.getNumbericPrice(Indetailprice);
	 
	 System.out.println(invprice);
	 String header=homepage.OpenCart();
	 Assert.assertEquals(header, "Products");
	 
	 header=homepage.clickOnCheckout();
	 Assert.assertEquals(header,"Your Cart" );
	 
	 header=homepage.EnteruserAddress("Saru","Bengluru","567678");
	 Assert.assertEquals(header,"Checkout: Overview");
	 
	 Map<String,String>taxAndTotalprice=homepage.getTaxAndTotalPrice();
	 float tax=homepage.getNumbericPrice(taxAndTotalprice.get("Tax"));
	 System.out.println(tax);
	 float total=homepage.getNumbericPrice(taxAndTotalprice.get("Total Price"));
	 System.out.println(total);
	 Assert.assertEquals(invprice+tax, total);
	 
	 header=homepage.Successfullyfinished();
	 Assert.assertEquals(header,"Checkout: Complete!");
	    }


}
