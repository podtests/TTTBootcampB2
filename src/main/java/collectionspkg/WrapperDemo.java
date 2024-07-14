package collectionspkg;



public class WrapperDemo {

    public static void main(String[] args) {


        int a = 8;

        //convert this to object
        //Boxing
        Integer a1 = Integer.valueOf(a);  //new Integer(a)


        //AutoBoxing
        Integer a2 = a;
        Integer al = 7;

        System.out.println(++al);

        //convert obj into PDT
        //UnBoxing
        int a3 = a1.intValue();


    }
}
