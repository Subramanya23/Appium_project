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
public class Activity_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "samsung SM-G935F");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void addTask() throws InterruptedException {
    	
       driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
       MobileElement firstTask =  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText");
       firstTask.sendKeys("Complete Activity with Google Tasks");
       driver.findElementById("add_task_done").click();
       Thread.sleep(2000);
       
       driver.findElementById("tasks_fab").click();
       Thread.sleep(2000);
       MobileElement secondTask =  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText");
       secondTask.sendKeys("Complete Activity with Google Keep");
       driver.findElementById("add_task_done").click();
       
       driver.findElementById("tasks_fab").click();
       Thread.sleep(2000);
       MobileElement thirdTask =  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText");
       thirdTask.sendKeys("Complete the second Activity Google Keep");
       driver.findElementById("add_task_done").click();
       Thread.sleep(2000);
       
       String third = driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"])[1]/android.widget.LinearLayout/android.widget.TextView").getText();
       Assert.assertEquals(third, "Complete the second Activity Google Keep");
       System.out.println(third);
      
       
       String second = driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"])[1]/android.widget.LinearLayout/android.widget.TextView").getText();
       Assert.assertEquals(second, "Complete Activity with Google Keep");
       System.out.println(second);
       Thread.sleep(2000);
     
      
       
       String first = driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"])[1]/android.widget.LinearLayout/android.widget.TextView").getText();
       Assert.assertEquals(first, "Complete Activity with Google Tasks");
       System.out.println(first);
       Thread.sleep(2000);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}