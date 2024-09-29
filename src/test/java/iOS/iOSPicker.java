package iOS;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class iOSPicker extends iOSBaseTest{
    @Test
    public void iOSPickerAction() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("255");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("105");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("215");
        Thread.sleep(50);

    }
}
