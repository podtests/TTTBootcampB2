package in.podtest.testng;

import in.podtest.util.ConfigReader;
import in.podtest.util.ScreenshotManager;
import in.podtest.util.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.LocalDateTime;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigReader.loadProperty("src/main/resources/config.properties");
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void preTestCase(String browserName) {
        if(browserName.equals("chrome")){
            WebDriverManager.createSession("chrome");
            System.out.println("Session id is: "+((ChromeDriver)WebDriverManager.getSession()).getSessionId().toString());
        } else {
            WebDriverManager.createSession("edge");
            System.out.println("Session id is: "+((EdgeDriver)WebDriverManager.getSession()).getSessionId().toString());
        }
    }

    @AfterMethod
    public void postTestCase(Method method) {
        String fileName = method.getName()+ LocalDateTime.now().getNano();
        String destFilePath = ScreenshotManager.takeScreenShot(WebDriverManager.getSession(),fileName );

        Reporter.log("<img src=../../"+destFilePath+" width="+40+"%/>");
        WebDriverManager.removeSession();
                //String filePath = "src/test/resources/screenshots/"+fileName+".png";
    }

}
