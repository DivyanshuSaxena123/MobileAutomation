package org.example;

import com.beust.ah.A;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RealTimeProjectTestCaseThreee extends BaseTest {
    @Test
    public void TestCaseThree(){
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"));")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Divyanshu Saxena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
        int cartCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).size();
        double totalsum = 0;
        for (int i=0; i < cartCount; i++) {
            String price = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).get(i).getAttribute("text");
            System.out.println(price);
            // now we are getting price as a string we can't perform addition on string so, we have to remove dollar from amount $160.93 $is at index 0
            Double originalPrice = Double.parseDouble(price.substring(1));
            totalsum = totalsum + originalPrice;

        }
        String displaySum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = Double.parseDouble(displaySum.substring(1));
        Assert.assertEquals(totalsum, displayFormattedSum);


        // Test case 4 - Long Press on T&C , Tapping on checkbox
        WebElement element = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));


        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration",2000));
        String alertTitle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "Terms Of Conditions");

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();




    }
}
