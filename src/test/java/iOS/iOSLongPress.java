package iOS;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class iOSLongPress extends iOSBaseTest {
    @Test
    public void longPressAction(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
        //[3] denotes we need to click 3rd no. modifier

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),"duration", 2000));
    }
}
