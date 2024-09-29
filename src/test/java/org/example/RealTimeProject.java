package org.example;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class RealTimeProject extends BaseTest {
    @Test
     // Test Case No. Fill the Form and verify the toast error


    public void FillForm(){

        //Test Case 1

        // Fill
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"));")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Divyanshu Saxena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // Verifying toast error

        /* What are toast message ?
        Ans - Some popup message popping up and after it get disappear are called toast message
        it is very hard to capture the toast message so, try replication this error in
        appium inspector we try to do that it is selecting entire page i.e we can't grab element using inspector,
        so what should we do now

        while doing development of an  application by default the toast tag name will be (android.widget.Toast)

         */

        //String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Assert.assertEquals(toastMessage, "Please enter your name");


        // Test Case 2 - Now we have to add item in the the cart
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));

        int prodCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i < prodCount; i++){
            String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan Lift Off")){
                driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));


        // Now we have to verify the item we have added is correct or not

        String lastPageProduct = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan Lift Off");










    }


}
