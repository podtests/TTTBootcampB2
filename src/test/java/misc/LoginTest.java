package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver wd = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));

    @BeforeMethod
    public void beforeSteps(){
        wd.get("https://demo.evershop.io/account/login");
    }


    @Test
    //testcase
    public void verifySuccessLogin() {
        String expectedData = "akhiljda@gmail.com";

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(expectedData);
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys("Password");
        wd.findElement(By.cssSelector("button[type='submit']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button[href='/women']")));

        wd.findElement(By.cssSelector("div.mini-cart-wrapper~div a[href='/account']")).click();

        //Assertion Library


        //
        String actualData = wd.findElement(By.xpath("//div[contains(@class, 'account-details-email')]//div[2]")).getText();
        Assert.assertEquals(actualData, expectedData);

    }


    @AfterMethod
    public void afterMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
        wd.findElement(By.xpath("//a[text()='Logout']")).click();

        wait.until(ExpectedConditions.urlToBe("https://demo.evershop.io/"));
        wd.quit();
    }
}
