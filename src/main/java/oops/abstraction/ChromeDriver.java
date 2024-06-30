package oops.abstraction;

public class ChromeDriver extends Driver{


    public void get(int a) {
        System.out.println("running get method with value of a as:"+a);
    }

   public void play() {
       run();

       get(5);
   }

}
