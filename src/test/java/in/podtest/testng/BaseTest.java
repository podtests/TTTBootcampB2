package in.podtest.testng;

import in.podtest.util.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigReader.loadProperty("src/main/resources/config.properties");
    }

}
