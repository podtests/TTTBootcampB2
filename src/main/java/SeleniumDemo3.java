import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDemo3 {

    public static void main(String[] args) {


        //main
        WebDriver wd = new ChromeDriver();
        //Thread.sleep(5000);

        //wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //global wait

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Shop men']")));

        FluentWait fw = new FluentWait(wd);
        fw.withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofSeconds(2))
                                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Shop men']")));

        wd.manage().window().maximize();



        //set the url
        wd.get("https://demo.evershop.io/account/login");
//Login
        //fill username details:
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");  //1 sec
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");  //5 sec


        //wait.until(ExpectedConditions.
        //button
        wd.findElement(By.xpath("//button[@type='submit']")).click();  //t1 : 9:30:1: 550



        //java will not wait by default

        // 9:30:1: 551
        //Homepage


        //Explicit wait

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Shop men']")));

        wd.findElement(By.xpath("//div[contains(@class,'product-name')]/a[contains(@href,'/geography-class-chuck-taylor-all-star')]")).click();  //t2

        //productpage
        wd.findElement(By.xpath("//input[@name='qty']")).clear();
        wd.findElement(By.xpath("//input[@name='qty']")).sendKeys("3");

        wd.findElement(By.xpath("//li/a[text()='XL']")).click();  //t1
        //t1+d1 = class=selected

        /*
        wait.until(
                ExpectedConditions.and(
                ExpectedConditions.attributeContains(wd.findElement(By.xpath("//li/a[text()='XL']//parent::li")), "class","selected"),
                ExpectedConditions.attributeContains(wd.findElement(By.cssSelector(".loading-bar")), "style","width: 0%; display: none;"))
        );
        */


        wd.findElement(By.xpath("//li/a[text()='Black']")).click();

        //wait.until(ExpectedConditions.attributeContains(wd.findElement(By.xpath("//li/a[text()='Black']//parent::li")), "class","selected"));

        wd.findElement(By.xpath("//span[text()='ADD TO CART']")).click();



        //Element NOt Found

        //Selenium: add implicit wait, 5 sec




    }
}
