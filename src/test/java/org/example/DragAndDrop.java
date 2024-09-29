package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest {
    @Test
    public void DragAndDropAction(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();

        // we will store the item that we have to drag
        WebElement source =  driver.findElement(AppiumBy.id(
                "io.appium.android.apis:id/drag_dot_1"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 625,
                "endY", 672
        ));

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");

    }

}
