package constructors;

public class Student {

    private String name;
    private int age;


    public  Student(String name2, int age2) {
        name =name2;
        age = age2;
    }



    public void getInfo() {
        System.out.println("Name is:"+name+ ", age is: "+age);
    }

    public void getDetails(String objName) {
        System.out.println(objName+ "Name is:"+name+ ", age is: "+age);
    }
}
