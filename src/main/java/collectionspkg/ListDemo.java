package collectionspkg;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> studentNames = new ArrayList<String>();

        //add
        studentNames.add("Raj");
        studentNames.add("Vikram");
        studentNames.add("Raj");


        //Iterate thru the list & print the values:
        for(String student :  studentNames ) {
            System.out.println(student);
        }


        //get value based on position
        System.out.println(studentNames.get(0));

        //count of items:
        System.out.println(studentNames.size());

        //delete the item
        //studentNames.remove(2);

        System.out.println("-------------");
        //Iterate thru the list & print the values:
        /*
        for(String student :  studentNames ) {
            System.out.println(student);
        }
         */

        //get the index pos of item
        System.out.println(studentNames.indexOf("Raj"));

        //check if value exist?
        System.out.println(studentNames.contains("Vikram"));




    }


}
