package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SwipeDemo extends BaseTest {
    @Test
    public void SwipeDemoAction() throws MalformedURLException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        //WebElement firstImage = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
        WebElement firstImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
        // This will check that initially focus is on 1st image
        //Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"), "true");
                Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"true");


        //Swipe Code

        // We don't need to provide these coordinate if we know on which element we are swiping
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)firstImage).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
    }
}
