package statics;

public class Employee {

    static int id;
    int age;

    //Static method
    public static String main2(){

        System.out.println(id);

        //System.out.println(age);

        return "AKhil Jain | PodTest.in";
    }

    //non-static method
    public void m2() {

        //static variable
        System.out.println(id);

        //non-static varaible
        System.out.println(age);
    }


}

