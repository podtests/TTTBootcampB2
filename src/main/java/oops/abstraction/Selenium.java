package oops.abstraction;

public class Selenium implements IDriver{


    @Override
    public void run() {
        System.out.println("Selenium is Running");
    }

    @Override
    public void click() {
        System.out.println("Selenium is Clicking");
    }
}
