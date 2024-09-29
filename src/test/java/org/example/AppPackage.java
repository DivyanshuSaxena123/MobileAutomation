package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppPackage extends BaseTest {
    @Test
    public void AppPackageAction() throws InterruptedException {
        /*
        No suppose we want to perform a certain action in app
        in which we have to open an app certain screen directly without performing
        all sections.

        This is done with the help of App Package  and App Activity
        App Package - In layman terms like Loyalty, Order & Gift Card this all modules
        are present in a app , so it make app an package

        App Activity - Loyalty is an activity, Ordering is another activity


        Steps :-
        1. There is a class call "Activity" , we will make an object of that call
        2. We have to pass 2 argument - app package and app activity
        3. First go to emulator and open that page on which we have to perform action and then open terminal run this command for mac
           adb shell dumpsys window | grep -E 'mCurrentFocus'
        4.


         */
        //Activity activity =  new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        Thread.sleep(9000);
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies" ));
        Thread.sleep(8000);
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String text = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(text, "WiFi settings");
        driver.setClipboardText("Divyanshu Saxena");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        Thread.sleep(6000);








    }
}
