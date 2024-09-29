package iOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iOSSliding extends  iOSBaseTest {
    @Test
    public void iOSSlidingAction() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == '42%'`]"));
        ele.sendKeys("0%");
        //System.out.println(ele.getAttribute("value"));
        //Assert.assertEquals("45%", ele.getAttribute("value"));
        //Thread.sleep(3000);
        //ele.sendKeys("1%");
        //System.out.println(ele.getAttribute("value"));
        //Assert.assertEquals("100%", ele.getAttribute("value"));


    }
}
