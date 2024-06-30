public class Day3 {

    int a = 5; //Instance variables

    public void printText(String name, int age) {
        int b = 10; //local variable
        System.out.println("Name is: "+name);
        System.out.println("Age is: "+(age-a- b));
        //System.out.println("Value of a is:"+a);
    }

    public void sayCheese() {
        System.out.println("Cheese");
    }

    //(4+6)^2
    //5+100
    //786+56


    public static void main(String[] args) {
        Day3 d3 = new Day3();

        d3.printText("Akhil", 100);  //invoking the method
        d3.sayCheese();

        int sum = d3.addition(4,6); //invoking the method  //10
        System.out.println(sum*sum);

    }

    public int addition(int a, int b) {
        int c = a+b; //4+6 =10;

        return c;  //10
        //return c;
        //c = 10;
        //System.out.println("Sum is: "+c);

    }


}
