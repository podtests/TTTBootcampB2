package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPOM {

    By fullNameTextBox = By.xpath("//input[@name='address[full_name]']");

    By telephoneTextBox = By.xpath("//input[@name='address[telephone]']");

    By addressTextBox = By.xpath("//input[@name='address[address_1]']");

    By cityTextBox = By.xpath("//input[@name='address[city]']");

    By postCodeTextBox = By.xpath("//input[@name='address[postcode]']");

    By provinceDD = By.xpath("//select[@id='address[province]']");

    By countryDD = By.xpath("//select[@id='address[country]']");

    By standardDeliveryRB = By.xpath("//div[@class='shipping-methods']//input[@type='radio' and @id='method0']");

    By expressDeliveryRB = By.xpath("//div[@class='shipping-methods']//input[@type='radio' and @id='method1']");

    By continueToPaymentButton = By.xpath("//button/span[text()='Continue to payment']");


    By shippingMethodSection = By.xpath("//div[@class='shipping-methods']//div[contains(@class,'text-textSubdued')]");

    public CheckoutPOM get() {
        wd.navigate().to("https://demo.evershop.io/checkout");
        return this;
    }

    public CheckoutPOM fillAddress(String address) {
        wd.findElement(addressTextBox).sendKeys(address);
        return this;
    }

    public CheckoutPOM fillTelephone(String telephone) {
        wd.findElement(telephoneTextBox).sendKeys(telephone);
        return this;
    }

    public CheckoutPOM fillFullName(String fullName) {
        wd.findElement(fullNameTextBox).sendKeys(fullName);
        return this;
    }


    public CheckoutPOM fillCity(String city) {
        wd.findElement(cityTextBox).sendKeys(city);
        return this;
    }

    public CheckoutPOM fillPostCode(String postcode) {
        wd.findElement(postCodeTextBox).sendKeys(postcode);
        return this;
    }


    //United States
    public CheckoutPOM selectCountryName(String countryName) {

        WebElement countryDDElement = wd.findElement(countryDD);
        Select countryDD = new Select(countryDDElement);

        countryDD.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPOM selectProvinceName(String provinceName) {
        WaitManager.waitForElementVisible(wd, provinceDD);

        WebElement provinceDDElement = wd.findElement(provinceDD);
        Select provinceDD = new Select(provinceDDElement);

        provinceDD.selectByVisibleText(provinceName);
        return this;
    }

    public CheckoutPOM selectDeliveryType(String deliveryType) {
        WaitManager.waitForElementNotVisible(wd,shippingMethodSection);

        if(deliveryType == "express") {
            wd.findElement(expressDeliveryRB).click();

        }else {
            wd.findElement(standardDeliveryRB).click();
        }
        return this;
    }

    //h4[text()='Shipping Method']//following-sibling::div


    public CheckoutPOM clickContinueToPaymentButton(){
        wd.findElement(continueToPaymentButton).click();
        return this;
    }



    WebDriver wd;

    public CheckoutPOM(WebDriver wd) {
        this.wd = wd;
    }

    public CheckoutPOM waitForPageLoad() {
        WaitManager.waitForPageLoad(wd,fullNameTextBox );
        return this;
    }
}
