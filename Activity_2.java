package project_Activities;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class Activity_2 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

  @Test
  public void keep() throws InterruptedException {
	  
	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	  MobileElement title =  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[8]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
	  title.sendKeys("First title");
	  Thread.sleep(2000);
	  
	  MobileElement Note = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[8]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
	  Note.sendKeys("First note");
	  Thread.sleep(2000);
	  
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  
	  String titleAdd = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"First title. First note. \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
	  Assert.assertEquals(titleAdd, "First title");
	  System.out.println(titleAdd);
	  
	  String NoteAdd = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"First title. First note. \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]").getText();
	  Assert.assertEquals(NoteAdd, "First note");
	  System.out.println(NoteAdd);
	  
	  
  }
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}

