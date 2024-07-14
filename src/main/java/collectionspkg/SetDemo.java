package collectionspkg;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        Set<String> studentNames = new HashSet<String>();

        //add operations:
        studentNames.add("Raj");
        studentNames.add("Vikram");
        studentNames.add("Raj");

        //iterate thru the items:
        for(String s: studentNames){
            System.out.println(s);
        }

        // size of set:
        System.out.println(studentNames.size());

        //cannot work on indexing in sets, why? because it doesn't maintain the order

        //delete the items?
        studentNames.remove("Vikram");

        //iterate thru the items:
        for(String s: studentNames){
            System.out.println(s);
        }

        //check if particular itemexist in set?
        System.out.println(studentNames.contains("Akhil"));




    }
}
