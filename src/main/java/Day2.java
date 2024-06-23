public class Day2 {

    public static void main(String[] args) {

/*
        int i =6;
        while(i <5) {
            System.out.println("Akhil Jain: Podtest.in");
            i++;
        }
  */

        int i=0;

        do {
            System.out.println("Akhil Jain: Podtest.in");
            i++;
        } while(i<5);






    }

    public void incrementalLogic() {
        int i = 0;


        System.out.println(i);  //0
        System.out.println(i+1); //1  //i+1  //i=0
        System.out.println(i);   //0
        System.out.println(i++); //output=0, i =0; i = i+1;
        System.out.println(i);  //1
        System.out.println(++i);  //i=i+1; //i=2 //2

    }

    public void forloop() {
        int a = 0;

        //a = a+1;
        a++;   //incremental operator

        a = a-1;
        a--;

        System.out.println(a);  //1


        for(int i =0; i<5; i++) {
            System.out.println("Akhil Jain: Founder of PodTest.in");
        }

    }

    public void bitWiseOperator() {
        int a = 7;
        int b = 3;

        int c= a & b;
        System.out.println(c);  //3
    }

    public void ternaryOperator() {
        int a= 7;

        String result = a > 9 ? "Pass" : "Fail";



        String res = a>9 ? (a >10 ? "Pass" : "Fail") : "Fail2";
        System.out.println(res);


        //bitwise operation

        //Short circuit operations
        // &&
        // ||




        //Bitwise operations:
        //&
        // |



        //shift operation

        if(a>9) {
            if(a >10) {
                result = "Pass";
            }
            else {
                result = "Fail";
            }
        } else {
            result = "Fail2";
        }


        System.out.println(result);
    }

    public void ifelsemethod() {
        int totalMarks = 100;
        //46<30  : F


        if(totalMarks <30) {
            System.out.println("Failed");
        }
        else if(totalMarks >=30 && totalMarks <75){
            System.out.println("Just Passed");
        }
        else if (totalMarks == 100){
            System.out.println("Achievement Unlocked! Great!");
        }
        else {
            System.out.println("Passed with distinction!");
        }

        char gend = 'F';
        String  gender = "Male"; //"Female"
        if(gend == 'M') {
            System.out.println("Class is on 3rd Floor!");
        }
       /*
        else if(gender == "Female") {
            System.out.println("Class is on Ground Floor!");
        }
        */
        else {
            System.out.println("Class is on Ground Floor!");
        }
    }

    public void switchCase() {
        String gender = "Others";

        switch(gender) {
            default: {
                System.out.println("Go to First Floor!");
            }

            case "Male" : {
                System.out.println("Go to 3rd Floor!");
                break;
            }
            case "Female": {
                System.out.println("go to Top Floor!");
                break;
            }



        }

    }
}
