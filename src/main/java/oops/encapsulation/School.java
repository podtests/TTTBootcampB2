package oops.encapsulation;

  public class School {

      int age1 ;


     public static void main(String[] args) {

        Student s1 = new Student();

        s1.setName("Akhil");

         System.out.println(s1.getName());
        s1.age = 10;
        s1.printInfo('M');

        Student s2 = new Student();


        s2.age = 100;
        s2.printInfo('M');


    }
}
