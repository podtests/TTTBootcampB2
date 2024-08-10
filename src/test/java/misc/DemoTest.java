package misc;

import org.testng.annotations.*;

public class DemoTest {

    @BeforeSuite
    public void BS() {
        System.out.println("BS executed!");
    }

    @AfterSuite
    public void AS() {
        System.out.println("AS executed!");
    }

   @BeforeTest
    public void BT() {
        System.out.println("BT executed!");
    }

    @AfterTest
    public void AT() {
        System.out.println("AT executed!");
    }

    @BeforeClass
    public void BC() {
        System.out.println("BC Executed!");
    }


    @AfterClass
    public void AC() {
        System.out.println("AC Executed!");
    }

    @BeforeMethod
    public void BM() {
        System.out.println("BM Executed!");
    }

    @AfterMethod
    public void AM() {
        System.out.println("AM Executed!");
    }

    @Test
    public void TC1() {
        System.out.println("TC1 executed!");
    }

    @Test
    public void TC2() {
        System.out.println("TC2 executed!");
    }
}
