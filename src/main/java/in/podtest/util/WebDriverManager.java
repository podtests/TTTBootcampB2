package in.podtest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {

    private static WebDriver wd ;

    static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static  WebDriver createSession(String browserName) {

        if(browserName.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

            wd = new ChromeDriver(options);
        }
        else {
            wd = new EdgeDriver();
        }
        threadLocal.set(wd);
        return threadLocal.get();
    }

    public static WebDriver getSession() {
        return threadLocal.get();
    }

    public static void removeSession() {
        threadLocal.get().quit();
        threadLocal.remove();
    }

}
