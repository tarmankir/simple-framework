package selenium.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import actions.ActionsWithDeviceSelenium;
import settings.SeleniumDriverSetup;
import settings.CapabilitiesSelenium;

import java.net.MalformedURLException;
import java.net.URL;

import static settings.Credentials.TEST_USER_1;
import static settings.MobileConfig.getMobileSetting;

public class SignInSeleniumScreenTest extends SeleniumDriverSetup {

    private AppiumDriver driver;
    private SignInSeleniumScreen signInSeleniumScreen;
    private MainSeleniumScreen mainSeleniumScreen;
    private AppMenuSeleniumScreen appMenuSeleniumScreen;
    private ActionsWithDeviceSelenium actionsWithDeviceSelenium;

    @BeforeMethod
    public void driverSet() throws MalformedURLException {
        driver = new AppiumDriver(new URL(getMobileSetting("urlAndroid")),new DesiredCapabilities(new CapabilitiesSelenium().getAndroidDesiredCapabilities()));
        signInSeleniumScreen = new SignInSeleniumScreen(driver);
    }

    @AfterMethod
    void afterMethod() {
        driver.quit();
    }

    @Test
    public void signInScreenTest() {
        signInSeleniumScreen.loginInApp(TEST_USER_1);
        signInSeleniumScreen.clickSignInButton();
        mainSeleniumScreen = new MainSeleniumScreen(driver);
        mainSeleniumScreen.openAppMenu();
        appMenuSeleniumScreen = new AppMenuSeleniumScreen(driver);
        appMenuSeleniumScreen.checkUserLoginName("ivakidov@ro.ru");
        actionsWithDeviceSelenium = new ActionsWithDeviceSelenium(driver);
        actionsWithDeviceSelenium.clickOnDeviceButtonBack();
    }
}