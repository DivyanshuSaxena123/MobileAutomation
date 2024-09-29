package iOS;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.List;

public class iOSBundleID extends iOSBaseTest{
    @Test
    public void iOSBundleIDAction(){

        // For bundleID either we can ask dev to give us or if there are in built app we can google the apple id
        // This method is basically about if we try to automate the inbuilt app in iPhone we will use Activity package like use Android
        // For ex here in iOS we open photos app and will perform swipe functionality
        /*
        There are 2 way of writing driver execute script one is below i have written and second is
        just to create Map object and pass that map object
         */


        ((JavascriptExecutor) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobileslideshow" ));
        driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
        List<WebElement> allPhoto =  driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[1]")).click();
        for(int i = 0; i < allPhoto.size(); i++){

            System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            ((JavascriptExecutor) driver).executeScript("mobile: swipe", ImmutableMap.of(
                    "direction", "left"
                    //"percent", 0.75
            ));
        }
        driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
        //or
        //driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();




    }
}
