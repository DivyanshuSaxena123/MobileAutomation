package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class BaseTest {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    // This will include all the code like Appium Server and Stop bcz this has to be done only once
    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        // Note :- This is the appium code -> this code will be sent to appium server -> then server will interpret the code we write for mobile automation and then it will interact with device

        /* 1. Now as we can see we have to manually start the appium server
        what if we write the code to start appium server yes we can */

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();



          /* 2. SLF4J waring is resolved when we added dependency for that in pom.xml and
        Neither ANDROID_SDK or ANDROID_HOME is exported this is resolved bcz always remember
        Latest updated version of Mac has terminal with zsh while older version support bash
        This website help me solved this - "https://kashanhaider.com/set-up-android-environment-variables-on-macos/ if after"
        entering "adb" command it shows data in terminal that it is working fine
        */

        UiAutomator2Options options = new UiAutomator2Options();
        options.setChromedriverExecutable("/Users/punchh_divyanshu/Downloads/chromedriver");
        options.setDeviceName("Pixel 8 API 33 Emulator");// Emulator
        //options.setDeviceName("Android Device"); // real device
        options.setApp("/Users/punchh_divyanshu/Desktop/MobileAutomationDemo/src/test/java/resources/General-Store.apk");


        /* 3. if we are using Android device then we have to create object of android driver and if we are
        using iOS Device then we have to create object of iOS driver
        */

        /* 4. In 1st we will send the path of appium and in 2nd argument we will send the device details */
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        /* This statement means that it will wait for 10sec until it found its locator if location is found
        in this time duration then it will resume the execution otherwise it will fail
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

    }

    // Since we use driver.quit() and server.stop() once we execute each test case so, for that we will create another method
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

}
