package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM {

    By shopWomenButton = By.xpath("//a/span[text()='Shop women']");

    String productItem = "//div[contains(@class, 'product-name')]/a/span[text()='$$']";


    WebDriver wd;
    public HomePOM(WebDriver wd) {
        this.wd = wd;
    }

    public HomePOM waitForPageLoad() {
        WaitManager.waitForPageLoad(wd,shopWomenButton );
        return this;
    }

    //Nike air zoom pegasus 35
    public ProductPOM clickProductItem(String productName) {
        String updatedProductItem = productItem.replace("$$",productName);
        wd.findElement(By.xpath(updatedProductItem)).click();
        return new ProductPOM(wd);

    }

    public CategoryPOM clickShopWomen() {
        wd.findElement(shopWomenButton).click();
        return new CategoryPOM(wd);
    }
}
