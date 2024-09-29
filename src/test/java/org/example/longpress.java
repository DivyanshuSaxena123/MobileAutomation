package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class longpress extends BaseTest {
    @Test
    public void LongPressGesture() throws MalformedURLException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text ='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        // Now to preform any Gesture Based action like long press, scroll etc. pls visit appium github gesture site

        // we will store this value and pass into "ImmutableMap.of" method. Any thing that is of "By." it is of WebElement type
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

        // we are basically typecasting the ele value that we have passed in ImmutableMap method

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000));

        /*
        Now, there are 2 ways to compare either we compare text or we use some other method just to check "Sample Menu"
        is displayed or not.
         */
        // 1st Method
        String menuText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title']")).getText();
        Assert.assertEquals(menuText, "Sample menu");

        // 2nd Method :-
        //Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("android:id/title")).isDisplayed());


        //Thread.sleep(3000);


    }
}
