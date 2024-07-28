import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumIFrames {

    public static void main(String[] args) {

        WebDriver wd = new ChromeDriver();
        wd.get("https://selectorshub.com/iframe-scenario/");

        //wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //wd.switchTo().frame("pact1");
        //wd.switchTo().frame(wd.findElement(By.xpath("//h3[text()='Memory Test']//following-sibling::iframe")));
        wd.switchTo().frame(1);

        wd.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Akhil");

        wd.switchTo().frame(0);

        wd.findElement(By.xpath("//input[@id='jex']")).sendKeys("jain");


        //wd.switchTo().parentFrame();
        //wd.switchTo().parentFrame();

        wd.switchTo().defaultContent();
        wd.findElement(By.xpath("//a[contains(text(),'Help?')]")).click();


    }
}
