package arrays;

public class A {

    //Instance variable
     int a1 ;   //0

    char ch;

    String s;

    public void m1( ){
        //Local Variable
        int a2 = 9;

       // System.out.println(a1);  //0
        System.out.println(ch);
        System.out.println(s);

    }

    public static void main(String[] args) {
        A a = new A();
        a.m1();
    }
}
