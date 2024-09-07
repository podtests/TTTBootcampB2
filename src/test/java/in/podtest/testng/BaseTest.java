package in.podtest.testng;

import in.podtest.util.ConfigReader;
import in.podtest.util.ScreenshotManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigReader.loadProperty("src/main/resources/config.properties");
    }

    @AfterMethod
    public void postTestCase(Method method) {
        ScreenshotManager.takeScreenShot(wd, "CartPage");
    }

}
