package collectionspkg;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> studentNames = new HashMap<Integer, String>();

        //insert the values
        studentNames.put( 1, "Raj");
        studentNames.put( 2, "Vikram");
        studentNames.put( 3, "Raj");
        studentNames.put( 2, "Akhil");

        //how to get specific value
        System.out.println(studentNames.get(3));

        System.out.println("---------");
        //Iterate thru entire map for values:
        for(String s : studentNames.values()) {
            System.out.println(s);
        }


        System.out.println("---------");
        //iterate thru the keys:
        for(Integer i : studentNames.keySet()) {
            System.out.println(i);
        }

        System.out.println("---------");
        //iterate thru the keys:
        for(Integer i : studentNames.keySet()) {
            System.out.println("Key is:"+i+ " : value is: "+studentNames.get(i));
        }


        //delete the values
        studentNames.remove(2);

        //remove key [key, value]
        studentNames.remove(3,"Raj");

        System.out.println("---------");
        for(Integer i : studentNames.keySet()) {
            System.out.println("Key is:"+i+ " : value is: "+studentNames.get(i));
        }

        //get size
        System.out.println(studentNames.size());

        //check key
        System.out.println(studentNames.containsKey(1));

        //check value
        System.out.println(studentNames.containsValue("Akhil"));
    }
}
