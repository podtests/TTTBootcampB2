package in.podtest.testng;


import in.podtest.pom.*;
import in.podtest.util.ConfigReader;
import in.podtest.util.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class E2ETestcases extends BaseTest{

    @DataProvider(name = "credentials")
    public Object[][] testData() {
        return ExcelReader.readDataFromExcelFile("Testdata.xlsx");
    }

    @Test(dataProvider = "credentials")
    public void verifyUserAbleToAccessWomenPageSuccess(String userName, String password) {
        WebDriver wd = null;
        if(ConfigReader.getProperty("browser").equals("chrome")){
            wd = new ChromeDriver();
        } else {
            wd = new EdgeDriver();
        }

        LoginPOM loginPOM = new LoginPOM(wd);
        CartPOM cartPOM = new CartPOM(wd);
        CheckoutPOM checkoutPOM = new CheckoutPOM(wd);

/*
        ArrayList<String> productData = loginPOM.get("https://demo.evershop.io/account/login")
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad().clickProductItem("Nike air zoom pegasus 35")
                .waitForPageLoad().fillQuantity("3").selectSize("M").selectColor("Blue").clickAddToCart()
                .waitForViewCartDialogBox().clickViewCart()
                .waitForPageLoad().getProductBasedOnRowNum(1);

        for(String data: productData) {
            System.out.println(data);
        }


        cartPOM.clickCheckoutButton()
                .waitForPageLoad().fillFullName("Akhil Jain").fillTelephone("9876543210").fillAddress("Delhi")
                .fillCity("East Delhi").selectCountryName("United States").selectProvinceName("Colorado").fillPostCode("110011")
                .selectDeliveryType("standard").clickContinueToPaymentButton();
*/

        loginPOM.get(ConfigReader.getProperty("applicationURL"))
                .fillUserName(userName).fillPassword(password).clickSubmit()
                .waitForPageLoad();

        checkoutPOM.get().waitForPageLoad().fillFullName("Akhil Jain").fillTelephone("9876543210").fillAddress("Delhi")
                .fillCity("East Delhi").selectCountryName("United States").selectProvinceName("Colorado").fillPostCode("110011")
                .selectDeliveryType("standard").clickContinueToPaymentButton();



       // Assert.assertEquals();

    }
}
