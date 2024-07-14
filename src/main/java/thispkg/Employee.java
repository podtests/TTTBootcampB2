package thispkg;

public class Employee {

    private String name;


    public Employee( String name) {
            this.name = name;

            this.getName();


    }

    public Employee(){

    }

    public Employee(Employee anotherEmp){

        //this();
          //this(anotherEmp.name) ;

          //instance variable
            System.out.println(this.name);
            //invoke the method
            this.getName();

            //invioke the constructor:


    }

    public void getName() {
        System.out.println(name);
    }
}
