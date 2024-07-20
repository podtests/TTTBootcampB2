import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) {


        //a new browser instance opens up
        WebDriver wd = new ChromeDriver();


        //set the url
        wd.get("https://demo.evershop.io/account/login");

        //fill username details:
        //wd.findElement()

    }
}
