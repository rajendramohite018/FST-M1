package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	// Declare Android driver
    AndroidDriver<MobileElement> driver;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	 // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "320014cec028b579");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }
 
    @Test
    public void add() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_add").click();
        driver.findElementById("calc_keypad_btn_09").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();
 
        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }
 
    @Test
    public void subtract() {
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_sub").click();
        driver.findElementById("calc_keypad_btn_05").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();
 
        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }
 
    @Test
    public void multiply() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_mul").click();
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_00").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();
 
        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }
 
    @Test
    public void divide() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_div").click();
        driver.findElementById("calc_keypad_btn_02").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();
 
        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
