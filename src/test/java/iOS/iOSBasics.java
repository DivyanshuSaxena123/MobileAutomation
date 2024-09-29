package iOS;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class iOSBasics extends iOSBaseTest{
    @Test
    public void BasicsTest(){
        // Just like android in iOS we use these locator - xpath, classname, iOS, iOSClassChain, iOSPredictedString, accessibility , id
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        /*
        Now we will learn about xpath and iOSClassChain
        both are similar but xpath (xpath is basically xml language) run slowly in iOS why bcz native app source code
        is not in XML

        iOSClassChain it is a hybrid of xpath
        iOSClassChain Format -
        */
        //driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();

        // Now, in below chain u must be wondering why we don't provide attribute and value bcz tag na
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello Divyanshu");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        // Predicate String -  Predicate means you give the matching string here. It give flexibility to look for locator in any form
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm/Cancel'")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type ==  'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        //or[c] denotes case sensitive
        //driver.findElement(AppiumBy.iOSNsPredicateString("type ==  'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();
        String text = driver.findElement(AppiumBy.iOSNsPredicateString("type ==  'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'A message'")).getText();
        System.out.println(text);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

        //Assignment






    }
}
