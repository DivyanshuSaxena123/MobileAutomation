package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellanousAppiumActions extends BaseTest {
    @Test
    public void Miscellanous(){
        //to perform testing in orientation there is class present in Appium
        // for example we are doing some action in landscape mode
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        // rotate
        DeviceRotation rotate = new DeviceRotation(0, 0, 90);
        driver.rotate(rotate);
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String text = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(text, "WiFi settings");
        // suppose if we want to copy-paste in text field
        driver.setClipboardText("Divyanshu Saxena");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());

        /*Suppose you want perform action of phone like in text field u want to
        go next line so, you have press enter on Phone Keyboard, like u have press
        Home Button of android to perform these action there is another class
        call Press Key
         */
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();






    }
}
