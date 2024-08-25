package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM {

    By addToCartButton = By.xpath("//button/span[text()='ADD TO CART']");

    By qtyTextBox = By.xpath("//input[@name='qty']");

    String sizeCheckBox = "(//ul[contains(@class,'variant-option-list')])[1]//li/a[text()='$$']";

    String colorCheckBox = "(//ul[contains(@class,'variant-option-list')])[2]//li/a[text()='$$']";

    By viewCartButton = By.xpath("//a[@class='add-cart-popup-button']");

    By loadingBar = By.xpath("//div[@class='loading-bar']");

    WebDriver wd;
    public ProductPOM(WebDriver wd) {
        this.wd = wd;
    }

    public ProductPOM fillQuantity(String qty){
        wd.findElement(qtyTextBox).clear();
        wd.findElement(qtyTextBox).sendKeys(qty);
        return this;
    }

    public ProductPOM selectSize(String size) {
        String updatedSizeCheckBox = sizeCheckBox.replace("$$", size);
        wd.findElement(By.xpath(updatedSizeCheckBox)).click();
        WaitManager.waitForElementLoad(wd,loadingBar, "style", "width: 0%; display: none;");
        return this;

    }

    public ProductPOM selectColor(String color) {
        String updatedColorCheckBox = colorCheckBox.replace("$$", color);
        wd.findElement(By.xpath(updatedColorCheckBox)).click();
        WaitManager.waitForElementLoad(wd,loadingBar, "style", "width: 0%; display: none;");
        return this;

    }

    public ProductPOM clickAddToCart() {
        wd.findElement(addToCartButton).click();
        return this;
    }

    public CartPOM clickViewCart() {
        wd.findElement(viewCartButton).click();
        return new CartPOM(wd);
    }


    public ProductPOM waitForPageLoad() {
        WaitManager.waitForPageLoad(wd,addToCartButton );
        return this;
    }

    public ProductPOM waitForViewCartDialogBox() {
        WaitManager.waitForPageLoad(wd,viewCartButton );
        return this;
    }


}
