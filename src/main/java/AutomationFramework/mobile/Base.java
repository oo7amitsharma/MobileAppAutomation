package AutomationFramework.mobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base {
	
	static AndroidDriver<AndroidElement> driver;
	@BeforeSuite
	public static void capabilities() throws IOException{
		String test =System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(test+"\\src\\main\\java\\AutomationFramework\\mobile\\global.properties");
		Properties properties = new Properties();
		properties.load(fis);
	//	properties.get(appName);
		
		File appDir = new File("src");
//		File app = new File(appDir, (String) properties.get(appName));
		String deviceBrowserStack = (String) properties.get("deviceBrowserStack");
		String os_version = (String) properties.get("os_version");
		String ShaadiApp = (String) properties.get("ShaadiApp");
		String appIDBrowserStack = (String) properties.get("appIDBrowserStack");
		String browserstack_user = (String) properties.get("browserstack_user");
		String browserstack_key = (String) properties.get("browserstack_key");
		String browserStack = (String) properties.get("browserStack");
		boolean isBrowserStack = Boolean.parseBoolean(browserStack);
		
		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
		DesiredCapabilities caps = new DesiredCapabilities();
	      caps.setCapability("browserstack.user", "amitkumar_BdFTv5");
	      caps.setCapability("browserstack.key", "ssa7xwurN9mkR3F23mxh");
	      caps.setCapability("app", "bs://d4f5c88e87d39e89250a8c60dac071a5436d0dd5");
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	      driver = new AndroidDriver<AndroidElement>(
		            new URL("http://hub.browserstack.com/wd/hub"), caps);

/*		 if(isBrowserStack) {
			 
			 System.out.println("browserstack_user: "+browserstack_user);
			 System.out.println("browserstack_key: "+browserstack_key);
			 System.out.println("appIDBrowserStack: "+appIDBrowserStack);
			 System.out.println("deviceBrowserStack: "+deviceBrowserStack);
			 System.out.println("os_version: "+os_version);			 
			 
			 capabilities.setCapability("browserstack.user", browserstack_user);
			 capabilities.setCapability("browserstack.key", browserstack_key);
			 capabilities.setCapability("app", appIDBrowserStack);
			 capabilities.setCapability("device", deviceBrowserStack);
			 capabilities.setCapability("os_version", os_version);
			
			 AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
			            new URL("http://hub.browserstack.com/wd/hub"), capabilities);
			}
		 else {
			 
			 capabilities.setCapability("app", test+"\\src\\test-relese.apk");		 
			 capabilities.setCapability("appPackage", "io.appium.android.apis");
			 capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			 capabilities.setCapability("deviceName", appIDBrowserStack);
			 capabilities.setCapability("platformVersion", os_version);
			 capabilities.setCapability("platformName", "Android");
			 AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
			 
		 }
		 */

	
		
	}
	
    @AfterSuite(alwaysRun = true)
  	public void tearDown() throws Exception {
  		if(driver!= null){
  			driver.quit();
  		}
  	}

}
