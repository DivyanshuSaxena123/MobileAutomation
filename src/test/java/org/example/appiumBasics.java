package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class appiumBasics extends BaseTest {

    /* @Test annotation is coming from TestNG Framework we need not to write public static void main it
    it will be covered in TestNG framework */

    /* By using the concept of Inheritance we have extend the feature of Base Class to appiumBasics and also if we don't
    use inheritance than we have to manually write CONFIGUREAPPIUM METHOD AND TEARDOWN METHOD FOR each test case
     */
    @Test
    public void WifiSettingName() throws MalformedURLException, URISyntaxException {


        /* If we don't use @BeforeClass and @AfterClass annotations
        ConfigureAppium();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        tearDown();
         */


        // As we already knows that the locator appium supports are - xpath, className, accessibilityId, id, androidUIAutomator

        // Syntax for Xpath - //tagName[@attribute='value'] or //"(tagName[indexPoint de skte hai])"


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        /*
        Before we enter any name to Wifi we have to make sure correct popup is opened
         */
       String alertTitle =  driver.findElement(By.id("android:id/alertTitle")).getText();
       Assert.assertEquals(alertTitle, "WiFi settings");
       driver.findElement(By.id("android:id/edit")).sendKeys("Rahul Wifi");


        //Now after giving wifi name we have to click on "ok" button so, this time we will use className as locator
        /*Now here the className for both "Cancel" and "Ok" button is same . so, we will differentiate
        if className is different then we can simply use "findElement" other we have to use
        "findElements"
        */
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


    }
}
