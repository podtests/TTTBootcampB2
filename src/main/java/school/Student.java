package school;

 public class Student {

    private String name = "Akhil";
    public int age;


    public void setName(String localName) {
        if (!localName.equalsIgnoreCase("jain")){
        }else {
            name = localName;
        }
    }

    public String getName() {
        return name;
    }


    public void printInfo(char genderInput) {
         char gender = genderInput;
        System.out.println("school.Student name is: "+name);
        System.out.println("Age is: "+age);
        System.out.println("Gender is:"+gender);
    }
}
