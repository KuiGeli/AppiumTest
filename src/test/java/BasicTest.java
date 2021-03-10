//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class BasicTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "JAAZGV310230MJE");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\gelik\\AppData\\Roaming\\appiumstudio\\original-apks\\com.doradogames.conflictnations.worldwar3com.bytro.sup.MainActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.doradogames.conflictnations.worldwar3");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.bytro.sup.MainActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void useExistingAccount() {
        driver.context("WEBVIEW_1");
        driver.findElement(By.linkText("Use Existing Account")).click();
        driver.findElement(By.id("func_loginbutton")).click();

        Assert.assertNotNull(driver.findElement(By.id("login_error_message")));
        Assert.assertTrue(driver.findElement(By.id("login_error_message")).isEnabled());

//        driver.findElement(By.id("func_sg_registerform_button")).click();

    }

    @Test
    public void testUntitled4() {
        driver.context("WEBVIEW_1");
        driver.findElement(By.linkText("Use Existing Account")).click();
        driver.findElement(By.id("func_loginbutton")).click();

//        Assert.assertNotNull(driver.findElement(By.id("login_error_message")));
        Assert.assertTrue(driver.findElement(By.id("login_error_message")).isEnabled());

//        driver.findElement(By.id("func_sg_registerform_button")).click();

    }

//    @Test
//    public void testPlayAsGuest() {
//        driver.findElement(By.xpath("//*[@class='android.view.View' and @height>0 and ./*[@text='PLAY AS GUEST']]")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@nodeName='DIV' and @width>0 and ./*[@text='Join random nation']]")));
//        driver.findElement(By.xpath("//*[@text='Join random nation']")).click();
//        driver.findElement(By.xpath("//*[@text='JOIN RANDOM NATION']")).click();
//    }


    @Test
    public void playAsGuest() {
        driver.findElement(By.xpath("//*[@class='android.view.View' and @height>0 and ./*[@text='PLAY AS GUEST']]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@nodeName='DIV' and @width>0 and ./*[@text='Join random nation']]")));
        driver.findElement(By.xpath("//*[@nodeName='DIV' and @width>0 and ./*[@text='Join random nation']]")).click();
    }



    @AfterEach
    public void tearDown() {
//        driver.removeApp("com.doradogames.conflictnations.worldwar3/com.bytro.sup.MainActivity");
        driver.quit();
    }
}
