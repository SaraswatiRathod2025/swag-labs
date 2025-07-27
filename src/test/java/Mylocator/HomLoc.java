package Mylocator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomLoc {
	WebDriver driver;
	By menu=By.id("react-burger-menu-btn");
	By productList =By.xpath("//div[@class='inventory_list']/div");
	By addToCart=By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']");
	By addToCart1=By.xpath("//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']");
     By addToCart2=By.name("add-to-cart-sauce-labs-backpack");
     By titleheader=By.className("title");
     By clickcart=By.className("shopping_cart_link");
     By checkout=By.id("checkout");
 	By Firstname=By.name("firstName");
 	By Lastname=By.name("lastName");
 	By Postalcode=By.name("postalCode");
 	By Continuebutton=By.id("continue");
 	//By headerOfPage=By.class("title");
 	By taxLabel=By.className("summary_tax_label");
 	By totalLabel=By.className("summary_total_label");
     By Finishbutton=By.id("finish");
     By lastText=By.tagName("h2");
     
 	
     
	By Indetailprice=By.className("inventory_details_price");






	 public  HomLoc(WebDriver driver) {//s1=saru,s2=null,s3=s1;
			this.driver = driver;
		}

		public boolean isMenuDispayed() {
			return driver.findElement(menu).isDisplayed();
			
		}
		
		public void Selectthreeproduct(String ProductName) {
			List<WebElement> allproducts=driver.findElements(productList);
			for(WebElement ele:allproducts){
			WebElement Eleheader=ele.findElement(By.xpath("./descendant::div[@class='inventory_item_name ']"));
			
			String name=Eleheader.getText();
			
			System.out.println("Name: "+name);
			
			if(name.equals(ProductName)) {
				Eleheader.click();
				break;
			
			}
			}
			}		
			
			public  String Addingproductcart()  {
				driver.findElement(addToCart).click();
				driver.findElement(addToCart1).click();
				driver.findElement(addToCart2).click();
				
				return driver.findElement(titleheader).getText().trim();
			}	
				
				
			public String Clickoncart() {
				driver.findElement(clickcart).click();
	
				return driver.findElement(titleheader).getText().trim();
				
			}
			
			public String  checkouts() {
				driver.findElement(checkout).click();
				return driver.findElement(titleheader).getText().trim();
			}
			
			
			public String EnterData(String fName,String lName, String code)  {
				driver.findElement(Firstname).sendKeys(fName);
				driver.findElement(Lastname).sendKeys(lName);
				driver.findElement(Postalcode).sendKeys(code);
				

				 return driver.findElement(titleheader).getText().trim();
				
			}
				
			public String continuebutton()  {
				driver.findElement(Continuebutton).click();
			
				return driver.findElement(titleheader).getText().trim();
				
			}
			
			public String clickFinish()  {
				driver.findElement(Finishbutton).click();
				
				return driver.findElement(titleheader).getText().trim();
			}
			
			public String getlasttext() {
				return driver.findElement(lastText).getText().trim();
			}
			
}
