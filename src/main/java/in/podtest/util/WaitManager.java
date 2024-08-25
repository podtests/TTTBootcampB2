package in.podtest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public static void waitForPageLoad(WebDriver wd, By locator) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementNotVisible(WebDriver wd, By locator) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(locator)));
    }


    public static void waitForElementVisible(WebDriver wd, By locator) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static void waitForElementLoad(WebDriver wd, By locator, String attrName, String value) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(locator,attrName, value));
    }
}
