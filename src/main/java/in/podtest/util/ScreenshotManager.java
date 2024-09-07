package in.podtest.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {

    public static void takeScreenShot(WebDriver wd, String fileName) {

        File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/resources/screenshots/"+fileName+".png";

        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
