package in.podtest.testng;


import in.podtest.pom.*;
import in.podtest.util.ConfigReader;
import in.podtest.util.ExcelReader;
import in.podtest.util.ScreenshotManager;
import in.podtest.util.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class E2ETestcases extends BaseTest{

    public static Logger logger = LogManager.getLogger(E2ETestcases.class.getName());

    @DataProvider(name = "credentials")
    public Object[][] testData() {
        return ExcelReader.readDataFromExcelFile("Testdata.xlsx");
    }

    @Test(dataProvider = "credentials")
    public void verifyUserAbleToAccessWomenPageSuccess(String userName, String password) {
        logger.debug("I am a debugging log");

        logger.trace("I am a trace log");

        logger.warn("I am a warn log");

        logger.fatal("I am a fatal  log");

        logger.info("Testcase Started!");
        WebDriver wd = WebDriverManager.getSession();

        logger.info("Username used is: "+userName);
        logger.info("password used is: "+password);


        LoginPOM loginPOM = new LoginPOM(wd);
        CartPOM cartPOM = new CartPOM(wd);
        CheckoutPOM checkoutPOM = new CheckoutPOM(wd);


        ArrayList<String> productData = loginPOM.get(ConfigReader.getProperty("applicationURL"))
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad().clickProductItem("Nike react phantom run flyknit 2")
                .waitForPageLoad().fillQuantity("3").selectSize("S").selectColor("Black").clickAddToCart()
                .waitForViewCartDialogBox().clickViewCart()
                .waitForPageLoad().getProductBasedOnRowNum(1);

        //ScreenshotManager.takeScreenShot(wd, "CartPage");

        for(String data: productData) {
            System.out.println(data);
        }


        cartPOM.clickCheckoutButton()
                .waitForPageLoad().fillFullName("Akhil Jain").fillTelephone("9876543210").fillAddress("Delhi")
                .fillCity("East Delhi").selectCountryName("United States").selectProvinceName("Colorado").fillPostCode("110011").
                selectDeliveryType("standard").clickContinueToPaymentButton();




        logger.info("Testcase Ended!");

/*
        loginPOM.get(ConfigReader.getProperty("applicationURL"))
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad();

        checkoutPOM.get().waitForPageLoad().fillFullName("Akhil Jain").fillTelephone("9876543210").fillAddress("Delhi")
                .fillCity("East Delhi").selectCountryName("United States").selectProvinceName("Colorado").fillPostCode("110011")
                .selectDeliveryType("standard").clickContinueToPaymentButton();
*/


       // Assert.assertEquals();

    }


    @Test(dataProvider = "credentials")
    public void verifyUserAbleToAccessWomenPageSuccess2(String userName, String password) {
        logger.debug("I am a debugging log");

        logger.trace("I am a trace log");

        logger.warn("I am a warn log");

        logger.fatal("I am a fatal  log");

        logger.info("Testcase Started!");
        WebDriver wd = WebDriverManager.getSession();

        logger.info("Username used is: "+userName);
        logger.info("password used is: "+password);

        LoginPOM loginPOM = new LoginPOM(wd);
        CartPOM cartPOM = new CartPOM(wd);
        CheckoutPOM checkoutPOM = new CheckoutPOM(wd);

        ArrayList<String> productData = loginPOM.get(ConfigReader.getProperty("applicationURL"))
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad().clickProductItem("Nike react phantom run flyknit 2")
                .waitForPageLoad().fillQuantity("3").selectSize("S").selectColor("Black").clickAddToCart()
                .waitForViewCartDialogBox().clickViewCart()
                .waitForPageLoad().getProductBasedOnRowNum(1);

        //ScreenshotManager.takeScreenShot(wd, "CartPage");

        for(String data: productData) {
            System.out.println(data);
        }

        logger.info("Testcase Ended!");

/*
        loginPOM.get(ConfigReader.getProperty("applicationURL"))
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad();

        checkoutPOM.get().waitForPageLoad().fillFullName("Akhil Jain").fillTelephone("9876543210").fillAddress("Delhi")
                .fillCity("East Delhi").selectCountryName("United States").selectProvinceName("Colorado").fillPostCode("110011")
                .selectDeliveryType("standard").clickContinueToPaymentButton();
*/


        // Assert.assertEquals();

    }
}
