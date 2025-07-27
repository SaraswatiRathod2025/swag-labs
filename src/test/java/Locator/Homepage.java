package Locator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	WebDriver driver;
	By menu=By.id("react-burger-menu-btn");
	By productList =By.xpath("//div[@class='inventory_list']/div");
	By addToCart=By.id("add-to-cart");
	By Indetailprice=By.className("inventory_details_price");
	By cartlink=By.className("shopping_cart_link");
	By headerOfpage=By.className("title");
	By checkout=By.id("checkout");
	By Firstname=By.name("firstName");
	By Lastname=By.name("lastName");
	By Postalcode=By.name("postalCode");
	By Continuebutton=By.id("continue");
	//By headerOfPage=By.class("title");
	By taxLabel=By.className("summary_tax_label");
	By totalLabel=By.className("summary_total_label");
    By Finishbutton=By.id("finish");
	
	
   	 public Homepage(WebDriver driver) {//s1=saru,s2=null,s3=s1;
		this.driver = driver;
	}

	public boolean isMenuDispayed() {
		return driver.findElement(menu).isDisplayed();
		
	}
	
	public void SelectOneproduct(String ProductName) {
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
		
		public String AddproducttoCart() {
			driver.findElement(addToCart).click();
			return driver.findElement(Indetailprice).getText().trim();
			
		}
		
		public  String OpenCart() {
			driver.findElement(cartlink).click();
			return driver.findElement( headerOfpage).getText().trim();
        }
		
		public String clickOnCheckout() {
			driver.findElement(checkout).click();
			return driver.findElement(headerOfpage).getText().trim();
		}
		
		public String EnteruserAddress(String fname,String lname,String code) {
			driver.findElement(Firstname).sendKeys(fname);;
			driver.findElement(Lastname).sendKeys(lname);
			driver.findElement(Postalcode).sendKeys(code);
			driver.findElement(Continuebutton).click();
			return driver.findElement(headerOfpage).getText().trim();
		}
		
		//use hashmap  there key n value
		public Map<String,String>getTaxAndTotalPrice() {
			Map<String,String> pricemap=new HashMap();
			String tax=driver.findElement(taxLabel).getText().trim();
			pricemap.put("Tax", tax);
			String total=driver.findElement(totalLabel).getText().trim();
			pricemap.put("Total Price", total);
			return pricemap;
		}

		
		
		public float  getNumbericPrice(String price) {
			String[] array=price.split(":");
			price=array[1].trim().replace("$", " ");
			return Float.parseFloat(price);
		}	
			
			public String Successfullyfinished() {
				 driver.findElement(Finishbutton).click();
				 System.out.println("Thank you for your order!");
				 return driver.findElement(headerOfpage).getText().trim();
			}				

}
