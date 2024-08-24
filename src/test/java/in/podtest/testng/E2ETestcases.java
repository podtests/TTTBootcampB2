package in.podtest.testng;


import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETestcases {

    @Parameters({"userName", "password"})
    @Test
    public void verifyUserAbleToAccessWomenPageSuccess(String userName, String password) {

        WebDriver wd = new ChromeDriver();
        LoginPOM loginPOM = new LoginPOM(wd);

        loginPOM.get("https://demo.evershop.io/account/login")
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad().clickShopWomen();

       // Assert.assertEquals();

    }
}
