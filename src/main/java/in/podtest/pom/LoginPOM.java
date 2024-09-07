package in.podtest.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

    public static Logger logger = LogManager.getLogger(LoginPOM.class.getName());
    By userNameTextBox = By.xpath("//input[@name='email']");
    By passwordTextBox = By.xpath("//input[@name='password']");
    By signInButton = By.xpath("//button[@type='submit']");

    WebDriver wd ;

    public LoginPOM get(String url) {
        logger.info("URL used is: "+ url);
        wd.get(url);
        return  this;
    }

    public LoginPOM(WebDriver wd) {
        this.wd = wd;
    }

    public LoginPOM fillUserName(String username){
        logger.info("Username is:"+username);

        wd.findElement(userNameTextBox).sendKeys(username);
        return this;
    }

    public LoginPOM fillPassword(String password){
        wd.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public HomePOM clickSubmit() {
        wd.findElement(signInButton).click();
        return new HomePOM(wd);
    }
}
