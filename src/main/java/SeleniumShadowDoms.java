import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumShadowDoms {

    public static void main(String[] args) {


        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://selectorshub.com/xpath-practice-page/");

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='userName']")));

        WebElement shadowHost = wd.findElement(By.xpath("//div[@id='userName']"));

        SearchContext shadowRootUserName = shadowHost.getShadowRoot();

        /*
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */

        wait.until(ExpectedConditions.visibilityOf(shadowRootUserName.findElement(By.cssSelector("input[id='kils']"))));

        shadowRootUserName.findElement(By.cssSelector("input[id='kils']")).sendKeys("Akhil");

    }
}
