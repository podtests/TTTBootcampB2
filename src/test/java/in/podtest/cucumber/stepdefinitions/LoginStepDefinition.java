package in.podtest.cucumber.stepdefinitions;

import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginStepDefinition {

    WebDriver wd;
    LoginPOM loginPOM;
    HomePOM homePOM;

    @Given("Application URL is open")
    public void application_url_is_open() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        wd = new ChromeDriver(options);
        loginPOM = new LoginPOM(wd);
        loginPOM.get("https://demo.evershop.io/account/login");
    }

    @When("user provides credentials as {string} and {string}")
    public void user_provides_valid_credentials_as(String username, String password) {
        loginPOM.fillUserName(username).fillPassword(password).clickSubmit();
    }

    @Then("user {string} get loggedIn successfully")
    public void user_should_get_loggedIn_successfully(String status) {
        boolean isLoggedIn = false;
        if(status.equals("should")) {
            homePOM = new HomePOM(wd);
            homePOM.waitForPageLoad();
            isLoggedIn = wd.getCurrentUrl().contains("login");  //false
            Assert.assertFalse(isLoggedIn);
        }else {
         wd.getCurrentUrl().contains("login");
            isLoggedIn = wd.getCurrentUrl().contains("login"); //true
            Assert.assertFalse(isLoggedIn);
        }
    }

}
