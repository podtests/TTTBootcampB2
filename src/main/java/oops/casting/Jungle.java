package oops.casting;

public class Jungle {

    public static void main(String[] args) {

        /*
        //parent = parent
        Animal a1 = new Animal();
        a1.eat();
        a1.walk();

        //child = child
        Lion l1 = new Lion();
        l1.eat();
        l1.sleep();
        l1.walk();
*/

        //child = parent
        //Not allowed
           //Lion l2  = new Animal();


        //Parent = child
        Animal a2 =  new Lion();
        //a2.eat();


        Lion l2 = new Lion();
        Animal a1 = (Animal)l2;

        Animal l3 = new Lion();
        Animal l4 = (Animal) l3;

       // l4.eat();


        //a2.sleep();


        //child = parent
        //Lion l5 = new Animal();
        Animal a5 = new Animal();
        Lion l6 = (Lion)a5;
           l6.eat();


    }
}
