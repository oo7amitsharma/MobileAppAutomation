package AutomationFramework.mobile;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
//import jci.kantech.UIAutomation.Driver.AppiumDriverInit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.lang.Thread.sleep;

import java.io.File;

public class ShaadiAndroidApp extends Base {
	 
	 @Test(priority=1)
	public void loginApp() throws Exception {
		// TODO Auto-generated method stub
		//ApiDemos-debug.apk
		
		
		//capabilities("APIDemoApp");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 MobileElement loginAtHomeScreen = (MobileElement) driver.findElementById("com.shaadi.android:id/btn_morph_login");
			loginAtHomeScreen.click();
			Thread.sleep(10000);
			MobileElement userName = (MobileElement) driver.findElementById("com.shaadi.android:id/edt_username");
			userName.sendKeys("10jun@200mails.com");
			MobileElement password = (MobileElement) driver.findElementById("com.shaadi.android:id/edt_password");
			password.sendKeys("shaadi");
			MobileElement loginButton = (MobileElement) driver.findElementById("com.shaadi.android:id/btn_login");
			loginButton.click();
			Thread.sleep(5000);
		 
	}
	
	 @Test(priority=2)
	public void navigateShaadiPage() {
		
		//Handle unwanted popup Rate the App on Play Store
		try {
			MobileElement removeExtraAdd = (MobileElement) driver.findElementById("com.shaadi.android:id/img_cancel");
			removeExtraAdd.click();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//Handle Add photo later popup
		try {
			MobileElement addPhotoLater = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Add Photos Later']");
			addPhotoLater.click();
			MobileElement notNow = (MobileElement) driver.findElementById("com.shaadi.android:id/btn_not_now");
			notNow.click();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Click on Shadi button to navigate Shaadi Page
		MobileElement myShaadiPage = (MobileElement) driver.findElementById("com.shaadi.android:id/imgMyShaadi");
		myShaadiPage.click();
		
		try {
			MobileElement fiveStarRatingPopup = (MobileElement) driver.findElementById("com.shaadi.android:id/iv_cancel");
			fiveStarRatingPopup.click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 @Test(priority=2)
	 public void sendConnectiontoPrimiumMatch() throws InterruptedException {
			TouchAction  action =new TouchAction(driver);
		   org.openqa.selenium.Dimension size =driver.manage().window().getSize();
		   int width=size.width;
		   int height=size.height;
		   int XCordinate= (int)(width*.046);
		   int startYCoordinate= (int)(height*.7);
		   int endYCoordinate= (int)(height*.3);
		   action.press(PointOption.point(XCordinate, startYCoordinate))
		         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		         .moveTo(PointOption.point(XCordinate, endYCoordinate)).release().perform();
		   
		   Thread.sleep(5000);
		   
		   MobileElement premiumMatchesTitle = (MobileElement) driver.findElementById("com.shaadi.android:id/tv_title");
		   premiumMatchesTitle.getText();
		   Assert.assertTrue(premiumMatchesTitle.getText().contains("Premium Matches"));

		   List<AndroidElement> premiumMatch =driver.findElements(By.id("com.shaadi.android:id/llConnect"));
		   System.out.println(premiumMatch.size());
		   for(AndroidElement element : premiumMatch) {
			   if(true) {
				   element.click();
				   break;
			   }
		   }
		   
		   try {
				MobileElement dismiss = (MobileElement) driver.findElementById("com.shaadi.android:id/btnDismiss");
				dismiss.click();
			  
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 @Test(priority=3)
	 public void sendConnectiontoNewMatch() {
		 
		 TouchAction  action =new TouchAction(driver);
		   org.openqa.selenium.Dimension size =driver.manage().window().getSize();
		   int width=size.width;
		   int height=size.height;
		   int XCordinate= (int)(width*.046);
		   int startYCoordinate= (int)(height*.7);
		   int endYCoordinate= (int)(height*.3);
		   
		   int i=2;
		   while(i>0) {
			   action.press(PointOption.point(XCordinate, startYCoordinate))
		         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		         .moveTo(PointOption.point(XCordinate, endYCoordinate)).release().perform();
			   i--;
		   }
 
			MobileElement newMatches = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='New Matches']");
			Assert.assertEquals("New Matches", newMatches.getText());
			List<AndroidElement> newMatch =driver.findElements(By.id("com.shaadi.android:id/llConnect"));
			   System.out.println(newMatch.size());
			   for(AndroidElement element : newMatch) {
				   if(true) {
					   element.click();
					   break;
				   }
			   }	
	 }

}
