import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumDemo {

    public static void main(String[] args) {


        //a new browser instance opens up
        WebDriver wd = new ChromeDriver();

        //set the url
        wd.get("https://demo.evershop.io/account/login");
//Login
        //fill username details:
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");

        //button
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Home Page
        //link click
        wd.findElement(By.xpath("//div[contains(@class,'product-name')]/a[contains(@href,'/geography-class-chuck-taylor-all-star')]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Product Page
        wd.findElement(By.xpath("//input[@name='qty']")).sendKeys("3");



        wd.findElement(By.xpath("//a[text()='XL']")).click(); //t1
        //t2[Browser] -> t3

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wd.findElement(By.xpath("//a[text()='Black']")).click();  //t2

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wd.findElement(By.xpath("//button/span[text()='ADD TO CART']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wd.findElement(By.xpath("//a[contains(@class,'add-cart-popup-button')  and contains(text(),'VIEW CART') ]")).click();
        //

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Cart Page
        wd.findElement(By.xpath("//a/span[text()='CHECKOUT']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Checkout screen
        WebElement countryDropdown = wd.findElement(By.xpath("//select[@id='address[country]']"));

        /*
            Select s1 = new Select(countryDropdown);

            //s1.selectByValue("IN");

            s1.selectByIndex(5); //south korea

            s1.selectByVisibleText("Algeria");

            List<WebElement> countryOptions =  s1.getOptions();
            for(WebElement we : countryOptions) {
                System.out.println("Name is: "+we.getText());
            }
          */


        //2nd approach to work with dropdowns:
        countryDropdown.click();
        List<WebElement> countryOptions = wd.findElements(By.xpath("//select[@id='address[country]']/option"));
        //count of options tag
            System.out.println("dd option count:"+countryOptions.size());

            //china
            countryOptions.get(2).click();

            for(WebElement e : countryOptions) {
                //System.out.println(e.getText());

                /*
                if (e.getText() == "India"){
                    e.click();
                }
                 */
                if(e.getAttribute("value") == "IN") {
                    e.click();
                }


            }



        //options List<WebElement>






                //WebELement is the interface: which has this sendKeys method,

        //wd.findElement(By.cssSelector("input[name='email']")).sendKeys("akhiljda@gmail.com");

        //wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");


        /*
        By.id();  //attribute in an elemenet
        ;   ////attribute in an elemenet
        By.tagName("form");  //tagname of the element
        By.className()  //attribute in an element
*/

    }
}
