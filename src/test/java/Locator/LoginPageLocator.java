package Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageLocator {
	WebDriver driver;
	By usernameEle = By.id("user-name");
	By passwordEle = By.id("password");
	By loginButton = By.id("login-button");
	By errormessage=By.tagName("h3");

	public LoginPageLocator(WebDriver driver) {
		this.driver =driver;
	}

	public void enterCredentials(String username,String password) {
		driver.findElement(usernameEle).sendKeys(username);
		driver.findElement(passwordEle).sendKeys(password);
		driver.findElement(loginButton).submit();
		
	}
	public String fetchErrorMessage() {
		return driver.findElement(errormessage).getText();
	}


}
