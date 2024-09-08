package in.podtest.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {

    public static String takeScreenShot(WebDriver wd, String fileName) {

        File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/resources/screenshots/"+fileName+".png";
        File destination = new File(filePath);
        try {
            FileUtils.copyFile(file,destination );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filePath;

    }


}
