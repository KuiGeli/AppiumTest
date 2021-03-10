//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
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
    public void testUntitled() {
        driver.context("WEBVIEW_1");
        driver.findElement(By.linkText("Use Existing Account")).click();
        driver.findElement(By.id("func_loginbutton"));
        driver.findElement(By.id("func_loginbutton")).click();
        driver.findElement(By.id("func_sg_registerform_button")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.removeApp("com.doradogames.conflictnations.worldwar3/com.bytro.sup.MainActivity");
        driver.quit();
    }
}
