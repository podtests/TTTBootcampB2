import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeleniumSwitchDemo {

    public static void main(String[] args) {
        SeleniumSwitchDemo d1 = new SeleniumSwitchDemo();
        d1.workOnAlertBox();
    }

    public void workOnMultipletabs() {
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://selectorshub.com/xpath-practice-page/");

        // https://selectorshub.com
       // int startIndex = wd.getCurrentUrl().indexOf("https://");
       // int endIndex = wd.getCurrentUrl().indexOf(".com");


        String defaultHandleId = wd.getWindowHandle();
        System.out.println("default handle is:"+defaultHandleId);

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wd.findElement(By.cssSelector(".elementor-heading-title a[rel='noopener']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<String> handles = wd.getWindowHandles();

        Map<String, String> tabs = new HashMap<String, String>();

        System.out.println("size of set is:"+handles.size());
        System.out.println("---------------");
        int endIndex =0;
        String tabName = null;
        for(String s: handles) {
            wd.switchTo().window(s);  //default tab
            endIndex = wd.getCurrentUrl().indexOf(".com");
            tabName = wd.getCurrentUrl().substring(8,endIndex);  //selectorshub
            tabs.put(tabName, s);
            System.out.println(s);
        }


        String defaultHandleId2 = wd.getWindowHandle();
        System.out.println("new handle is:"+defaultHandleId2);

        wd.switchTo().window(tabs.get("selectorshub"));
        wd.switchTo().window(tabs.get("testrigor"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wd.findElement(By.xpath("//a[text()='Request a Demo']")).click();

        //click on a tab using handleid;


        //opens a new tab
    }

    public void workOnAlertBox() {

        WebDriver wd = new ChromeDriver();
        wd.get("http://127.0.0.1:5500/htmlcssjspage.html");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.findElement(By.cssSelector("input[id='submit']")).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alertBox = wd.switchTo().alert();
        System.out.println(alertBox.getText());

        alertBox.accept();

        //alert box appears
        wd.findElement(By.cssSelector("input[id='userName']")).sendKeys("Akhil");

    }


}
