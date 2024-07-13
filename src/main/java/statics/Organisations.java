package statics;

public class Organisations {


    final int age3 = 10;

    static int empCount = 10;

    public final void method1() {
        System.out.println("Akhil jain");
    }

    public final void method1(int a) {
        System.out.println("Akhil jain");
    }


    public static void getDetails(){
        System.out.println("details");
    }




    public static void main(String[] args) {

        getDetails();
        System.out.println(empCount);


        Organisations o1 = new Organisations();
        System.out.println(o1.empCount);
        o1.getDetails();

       o1.method1();



        /*
        Employee e1 = new Employee();
        e1.age= 10;
        e1.id= 1;
        System.out.println(e1.age);  //10
        System.out.println(e1.id); //1

        System.out.println("---------------");

        Employee e2 = new Employee();

        System.out.println(e2.age);  //0
        System.out.println(e2.id);  //1
*/
        Employee.id=10;
        System.out.println(Employee.id);
        System.out.println(Employee.main2());
    }
}
