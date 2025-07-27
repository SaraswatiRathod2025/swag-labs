package Mytest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import Base.Handlebrowser;
import Mylocator.HomLoc;
import Mylocator.LogLoc;

public class hmPage extends Handlebrowser {
	@Test(description = "varify the product")
	public void VarifyProcessingOfItem() throws InterruptedException {
		LogLoc lg = new LogLoc(driver);// constructor
		lg.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		
		HomLoc hp = new HomLoc(driver);
		

		Assert.assertTrue(hp.isMenuDispayed());
		
		//String add=hp.Addingproductcart();
		
		
		String titleheader=hp.Addingproductcart();
		Assert.assertEquals(titleheader,"Products");
	
		
		
		
		 titleheader=hp.Clickoncart();
		 Thread.sleep(4000);
		//Assert.assertEquals(titleheader,"Your Cart");
		
		
		 titleheader=hp.checkouts();
		 Thread.sleep(4000);
		Assert.assertEquals(titleheader,"Checkout: Your Information");
		
		
		String text=hp.EnterData("sarur","lamani", "453456");
		Thread.sleep(3000);
		titleheader=hp.continuebutton();
		 Thread.sleep(5000);
		Assert.assertEquals(titleheader,"Checkout: Overview");
		

	
	String finish=hp.clickFinish();
	Thread.sleep(7000);
	//Assert.assertEquals(finish,"Checkout: Complete!");
			
	
	titleheader=hp. getlasttext() ;
	//Assert.assertEquals(titleheader,"Checkout: Complete!");
	Assert.assertEquals(titleheader,"Thank you for your order!");
	System.out.println("complete order:"+titleheader);
	
	
		
		 



	}

	


}
