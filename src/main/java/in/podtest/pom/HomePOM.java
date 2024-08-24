package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM {

    By shopWomenButton = By.xpath("//a/span[text()='Shop women']");

    WebDriver wd;
    public HomePOM(WebDriver wd) {
        this.wd = wd;
    }

    public HomePOM waitForPageLoad() {
        WaitManager.waitForPageLoad(wd,shopWomenButton );
        return this;
    }

    public void clickShopWomen() {
        wd.findElement(shopWomenButton).click();
    }
}
