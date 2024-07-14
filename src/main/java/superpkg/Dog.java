package superpkg;

public class Dog extends Animal{


    public String name;

    public Dog() {

        //default parent constructor calling
       //super();

        //Animal a1 = new Animal(7);
        super(5);
        System.out.println("Dog Object being Created!");
    }


}
