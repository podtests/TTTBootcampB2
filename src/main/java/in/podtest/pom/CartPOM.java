package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPOM {

    By checkoutButton = By.xpath("//a/span[text()='CHECKOUT']");

    By productRows = By.xpath("//div[@id='shopping-cart-items']//tbody/tr");

    By productColumns = By.xpath("//div[@id='shopping-cart-items']//thead/tr/td");

    By productName = By.xpath("td[1]//a[contains(@class,'name')]");

    By productPrice = By.xpath("td[2]//span[@class='sale-price']");

    By productQuantity = By.xpath("td[3]//span");

    By productTotalPrice = By.xpath("td[4]//span");
    WebDriver wd;

    Map<Integer,ArrayList<String> > products = new HashMap<Integer, ArrayList<String>>();


    public CartPOM(WebDriver wd) {
        this.wd = wd;
    }

    public int getProductRowsCount() {
        return wd.findElements(productRows).size();
    }

    public int getColumnCount() {
      return  wd.findElements(productColumns).size();
    }


    public CartPOM waitForPageLoad() {
        WaitManager.waitForPageLoad(wd,checkoutButton);
        return this;
    }


    public Map<Integer, ArrayList<String>> readProductTable() {

        List<WebElement> rows = wd.findElements(productRows);  //tr
        int rowIndex =0;

        for(WebElement row : rows){
            rowIndex++;
            ArrayList<String> rowContent = new ArrayList<String>();
            rowContent.add(row.findElement(productName).getText());
            rowContent.add(row.findElement(productPrice).getText());
            rowContent.add(row.findElement(productQuantity).getText());
            rowContent.add(row.findElement(productTotalPrice).getText());

            products.put(rowIndex, rowContent);
        }

        return products;

    }

    public ArrayList<String> getProductBasedOnRowNum(int rowNum) {
        readProductTable();
        return products.get(rowNum);
    }





    public CheckoutPOM clickCheckoutButton() {
        wd.findElement(checkoutButton).click();
        return new CheckoutPOM(wd);
    }
}
