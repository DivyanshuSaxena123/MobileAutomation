package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

// With the help of Appium we can also test "Mobile Browser Also"
public class MobileBrowser extends BrowserBaseTest {
    @Test
    public void MobileBrowserTesting() throws InterruptedException {
        /*
        Now we have to make certain change in capabilities since here we are not
        invoking any we are invoking the browser so, we make separate file called
        BrowserBasedTest
         */

        //Now this is completely selenium Appium supports browser testing

        /*
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        Thread.sleep(900);
        driver.findElement(By.name("q")).sendKeys("upgrad");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(8000);

         */


        //Scrolling and Some other action on Mobile Web Browser
        // can use inspector to inspect mobile browser answer is no for this u have to inspect in browser by inspecting in mobile app
        // Add one extension to chrome browser "Selector Hub" which help in validation of locator on the fly
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
        //here i am using css locator just for learning purpose CSS Locator Format - tagname[attribute='value']
        String text = driver.findElement(By.cssSelector("a[href='/angularAppdemo/products/3']")).getText();
        Assert.assertEquals(text, "Devopss");



    }
}
