package iOS;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

public class iOSScrollView extends iOSBaseTest{
    @Test
    public void iOSScrollViewAction() throws InterruptedException {

        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        //Java
        Map<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll", scrollObject);
        Thread.sleep(2000);

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();

        //Performing this action on Mountain Mike :-

        //driver.findElement(AppiumBy.accessibilityId("btnNotMigrate")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == 'Email Email'`][3]")).click();
        //Thread.sleep(2000);
        //driver.findElement(AppiumBy.iOSClassChain( "**/XCUIElementTypeTextField[`name == 'email'`]")).sendKeys("divyanshu.saxena+98@partech.com");
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == 'Password Password'`]")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == 'Password Password'`]")).sendKeys("Test@1234");
        //driver.findElement(AppiumBy.iOSClassChain( "**/XCUIElementTypeButton[`name == 'Done'`][2]")).click();
        //driver.findElement(AppiumBy.accessibilityId("sign in. is disabled. Please fill above fields to continue.")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Done'`][2]")).click();
        //Thread.sleep(100);
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Save Password'`]")).click();
        //driver.findElement(AppiumBy.accessibilityId("Save Password")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Save Password'")).click();
        //driver.findElement(AppiumBy.accessibilityId("Rewards")).click();





    }
}
