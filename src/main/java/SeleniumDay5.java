import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.File;
import java.io.IOException;

public class SeleniumDay5 {

    public static void main(String[] args) {

        String chromeProfile = "C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + chromeProfile);

        WebDriver wd = new ChromeDriver(options);

        SessionId id = ((ChromeDriver)wd).getSessionId();
        System.out.println("id1:"+id);

        /*
        wd.close();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SessionId idAfterClose = ((ChromeDriver)wd).getSessionId();
        System.out.println("idAfterClose:"+idAfterClose);
           */

        /*
        wd.quit();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SessionId idAfterQuit = ((ChromeDriver)wd).getSessionId();
        System.out.println("idAfterQuit:"+idAfterQuit);
*/

    }

    public void screeshots() {
        WebDriver wd = null;
        //new FirefoxDriver();
        //FirefoxDriver wd = new FirefoxDriver();

        String browser = "chrome";
        if(browser.equals("chrome")){
            wd = new ChromeDriver();
        }else {
            wd = new FirefoxDriver();
        }


        //wd = new FirefoxDriver();

        wd.get("https://demo.evershop.io/account/login");

        WebElement signInButton = wd.findElement(By.cssSelector("button[type='submit']"));
        File signInScreenshot  = signInButton.getScreenshotAs(OutputType.FILE);



        //File screenshot1 =   ((ChromeDriver)wd).getScreenshotAs(OutputType.FILE);
        File screenshot =   ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("output.png"));
            FileUtils.copyFile(signInScreenshot, new File("signIn.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void javascriptDemo() {
        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");

        WebElement submitButton = wd.findElement(By.cssSelector("button[type='submit']"));
        // ((JavascriptExecutor)wd).executeScript("arguments[0].click();",submitButton );

        //((JavascriptExecutor)wd).executeScript("document.querySelector(\"button[type='submit']\").click()");
    }
}
