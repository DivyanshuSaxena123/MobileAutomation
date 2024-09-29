package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {
    @Test
    public void ScrollDemoTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        /*
        Now there are 2 methods to checkScrollable
        1. By using UiAutomator
        2. Appium github method
         */

        //UiAutomator Method
        /*
        UiAutomator is provided by google this can be used when we know till what element
        we have to scroll
         */
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));


        /*2nd Method (Appium GitHub Method) when no prior information available
        if we use this method without using do while it scroll a bit
         */
        boolean canScrollMore;
        do {
             canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while(canScrollMore);
    }
}
