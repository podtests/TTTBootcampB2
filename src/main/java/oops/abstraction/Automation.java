package oops.abstraction;

public class Automation {

    public static void main(String[] args) {

        Selenium s1 = new Selenium();

        s1.run();
        s1.click();

        IDriver i1 = new Selenium();
        i1.run();
        i1.click();






    }
}
