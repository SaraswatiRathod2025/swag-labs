package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlebrowser {
	public WebDriver driver;
	 public Properties prop=new Properties();
	@BeforeMethod
	public void openbrowser() throws IOException {	
	
		FileInputStream fis=new FileInputStream("C:\\Java_Selenium\\sara\\Myframework\\Configuration\\config.properties");
		prop.load(fis);
		
		
		String browser=prop.getProperty("browser").toString();
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
			//Enable JavaScript by not disabling it
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.javascript", 1); // 1 = Allow
			options.setExperimentalOption("prefs", prefs);
//options.addArguments("--disable-javascript");

			 driver=new ChromeDriver();
			 pagePreRequisites();
			
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver=new EdgeDriver();
			 pagePreRequisites();
		}
		else if(browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			 pagePreRequisites();
		}
		else {
			throw new InvalidArgumentException("Invalid  browser:"+browser);
		}
		
		
	}
	@AfterMethod
	public void closebrowser() {
		
		if(driver!=null)//exit not exactly through error
		driver.quit();
		
	}
	
	public void pagePreRequisites() {
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String wait=prop.getProperty("implicitlyWait");//"10"-10		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(wait)));
	}
	
		
		


}
