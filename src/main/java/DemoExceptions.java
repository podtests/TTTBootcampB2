import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoExceptions {



    public static void main(String[] args) {
        DemoExceptions demo = new DemoExceptions();
        //demo.sumUpElementsofArray(new int[]{2,3});  //5
        demo.openURL();

        /*
        try {
            demo.openURL();
        } catch (MalformedURLException e) {

            throw new RuntimeException(e);
        }

         */
    }


    //unchecked excpetion: Run Time
    public void sumUpElementsofArray(int[] arr1) {

        int len = arr1.length;
        int sum = 0;

        for(int i =0; i<=arr1.length; i++) {
            sum += arr1[i];
        }

        System.out.println("Sum of Array element is:"+ sum);

    }

    //checked exceptions: compile time
    public void openURL()  {
        WebDriver wd = new ChromeDriver();
        //wd.navigate().to(new URL("akhil.jain"));


        try {
            wd.navigate().to(new URL("akhil.jain"));
            System.out.println("I am getting executed after the exceptioon occured in try block");
        } catch(Exception e) {
            wd.navigate().to("https://youtube.com/@namastetest");
            System.out.println("Exception occurred!, But I handled it!");
            e.printStackTrace();
        }



        System.out.println("My Name is Akhil Jain!");
    }

}
