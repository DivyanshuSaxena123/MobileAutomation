package iOS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class iOSBaseTest {
    public AppiumDriverLocalService service;
    public IOSDriver driver;

    // This will include all the code like Appium Server and Stop bcz this has to be done only once
    @BeforeClass
    public void iOSConfigureAppium() throws URISyntaxException, MalformedURLException {


        /*
        IMPORTANT NOTE: - If we want to run test automation on iOS real device then we have sent
        only 2 capabilities
        1. App Path - option.setApp(""); we will not send device name and platform version it will automatically detect it
        2. We have to open web-driver project
        3. Then we have to select web driver runner and make sure we have selected "Device Connected via Cable"
        4. Make Sure we are a login apple developer account in xcode & check signing & capabilities in xcode it should be proper

        -----------------------------------------------------------------------------------------------------------

        IMPORTANT NOTE: - If we want to run test automation on Simulator These are the capabilities
        we have to send in code
        1. options.setDeviceName("");
        2. options.setApp("");
        3. option.setPlatformVersion("");

         */


        /*
        NOTE: - (How to resolve this error) Some time we run the code and found this error - XCRUN iphone simulator sdk not found
        Step 1. - Open Terminal
        Step 2. - xcode-select -p (This will xcode current path)
        Step 3. - Run these 2 commands
                 a) export DEVELOPER_DIR=/Applications/Xcode.app/Contents/Developer
                 b) export PATH=/Applications/Xcode.app/Contents/Developer/Platforms/iPhoneSimulator.platform/Developer/usr/bin:/Applications/Xcode.app/Contents/Developer/usr/bin:$PATH
        Step 4. - xcode-select -p (It will give - /Applications/Xcode.app/Contents/Developer)

         */


        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();


        XCUITestOptions options = new XCUITestOptions();
        //options.setChromedriverExecutable("/Users/punchh_divyanshu/Downloads/chromedriver-mac-x64");
        options.setDeviceName("iPhone 12 mini");
        options.setApp("/Users/punchh_divyanshu/Library/Developer/Xcode/DerivedData/UIKitCatalog-awclvqlxxucovxaxgfhxokvvyzjw/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        //options.setApp("/Users/punchh_divyanshu/Downloads/MountainMikesPizza 3.app");

        //ios we have to set a version of simulator
        options.setPlatformVersion("17.5");
        //Appium -> Web Driver Agent (WDA) -> IOS Apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(2300));



        /* 3. if we are using Android device then we have to create object of android driver and if we are
        using iOS Device then we have to create object of iOS driver
        */

        /* 4. In 1st we will send the path of appium and in 2nd argument we will send the device details */
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        /* This statement means that it will wait for 10sec until it found its locator if location is found
        in this time duration then it will resume the execution otherwise it will fail
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2300));

    }

    // Since we use driver.quit() and server.stop() once we execute each test case so, for that we will create another method
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
