package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Feature {

    //WebDriver wd;
    //WebDriverWait wait;

    @DataProvider(name = "basicData")
    public Object[][] testData() {

        String[][] data = new String[][] {
                {"akhiljda@gmail.com", "Password"}
        };

        return data;

    }

    @Parameters({"browserName"})
    @BeforeMethod( alwaysRun = true)
    public void preStep(String browserName) {
        /*
        if(browserName.equals("chrome")){
            wd = new ChromeDriver();
        }else {
            wd = new EdgeDriver();
        }

        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.get("https://demo.evershop.io/account/login");

         */
    }


    @Test(dataProvider = "basicData", groups = {"sanity"})
    public void tc1(String email, String pass) {

        WebDriver wd = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.get("https://demo.evershop.io/account/login");

        String expectedData = email;

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(expectedData);
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button[href='/women']")));
        wd.findElement(By.cssSelector("div.mini-cart-wrapper~div a[href='/account']")).click();

        String actualData = wd.findElement(By.xpath("//div[contains(@class, 'account-details-email')]//div[2]")).getText();
        Assert.assertEquals(actualData, expectedData);

        wd.findElement(By.xpath("//a[text()='Logout']")).click();
        wd.quit();
    }

    @Test(dataProvider = "basicData", groups = {"sanity"})
    public void tc2(String email, String pass) {
        WebDriver wd = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.get("https://demo.evershop.io/account/login");
        String expectedData = email;

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(expectedData);
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button[href='/women']")));
        wd.findElement(By.cssSelector("div.mini-cart-wrapper~div a[href='/account']")).click();

        String actualData = wd.findElement(By.xpath("//div[contains(@class, 'account-details-email')]//div[2]")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualData, "akhil"); //F

        System.out.println("Execution continued1!");

        String nameActualValue = wd.findElement(By.cssSelector("div.account-details-name div~div")).getText();
        softAssert.assertEquals(nameActualValue, "Akhil"); //P

        System.out.println("Execution continued2!");
        softAssert.assertAll();

        System.out.println("Execution continued3!");

        wd.findElement(By.xpath("//a[text()='Logout']")).click();
        wd.quit();


    }


    @AfterMethod( alwaysRun = true)
    public void postStep(){

    }
}
