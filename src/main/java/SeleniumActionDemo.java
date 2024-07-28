import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumActionDemo {

    public static void main(String[] args) {

        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        Actions actions = new Actions(wd);

        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");  //1 sec
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");  //5 sec


        //wait.until(ExpectedConditions.
        //button
        wd.findElement(By.xpath("//button[@type='submit']")).click();  //t1 : 9:30:1: 550

        WebElement ele = wd.findElement(By.xpath("//div[contains(@class,'product-name')]/a[contains(@href,'/geography-class-chuck-taylor-all-star')]"));
        //actions.moveToElement(ele).perform();

        //actions.scrollToElement(ele).perform();
        actions.scrollByAmount(0, 200).perform();
        //wd.findElement(By.xpath("//div[contains(@class,'product-name')]/a[contains(@href,'/geography-class-chuck-taylor-all-star')]")).click();  //t2







    }

    public void copyPasteLogic() {

        WebDriver wd = new ChromeDriver();

        wd.get("https://demo.evershop.io/account/login");
        Actions actions = new Actions(wd);
/*
        actions
                //.moveToElement(wd.findElement(By.xpath("//input[@name='email']")))
                //.click()
                .click(wd.findElement(By.xpath("//input[@name='email']")))
                .keyDown(Keys.SHIFT)
                .sendKeys("akhil")
                .keyUp(Keys.SHIFT)
                .perform();

        actions.click(wd.findElement(By.xpath("//input[@name='email']")))
                .keyDown(Keys.SHIFT)
                .sendKeys("akhil")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.TAB)
                .sendKeys("Password")
                .perform();

        actions.click(wd.findElement(By.xpath("//input[@name='password']")))
               // .sendKeys(Keys.TAB) //SignIn, password
                .sendKeys(Keys.ENTER)
                .perform();
*/

        actions.click(wd.findElement(By.xpath("//input[@name='email']")))
                //write in caps
                .keyDown(Keys.SHIFT)
                .sendKeys("akhil")
                .keyUp(Keys.SHIFT)
                //select teh text
                .keyDown(Keys.CONTROL)
                .sendKeys("a")

                //copy the text
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                //move to password
                .sendKeys(Keys.TAB)

                //paste teh copied value
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .perform();

    }
}
