package arrays;

public class ArrayDemo {

    boolean[] intMarks = new boolean[5];

    int[][] marks = new int[2][4];

    int[][] custommarks = new int[2][];


    public void custom2dArray() {

        //set teh value per cell
        //custommarks[0][1] = 0;


        //arary assignments
        int[] a1 = {20,30};
        int[] a2 = {20,30,40};

        custommarks[0] =  a1;
        custommarks[1] = a2;

        System.out.println("Length of 2d array: "+ custommarks.length); //2

        for(int i =0; i<custommarks.length; i++) {
            System.out.println("size of SubArray ["+i+"] is: "+custommarks[i].length);
        }

        System.out.println("--------------");

        //iterate thry 2d arrays
        for(int i =0; i<custommarks.length; i++) {

            for(int j = 0;j <custommarks[i].length; j++ ){
                System.out.print(custommarks[i][j]+" ");
            }
            System.out.println();


        }




    }

    public void array2d() {

        //insert the value
        marks[0][0]= 7;

        System.out.println(marks.length); //2  //Get number of rows

        System.out.println(marks.length);  //4  //get number of columns in a particular row


    }

    public void m1() {
        boolean[] marks = new boolean[5];

        //iterate thru the array:


        //iterate thru the array:
        for(int i =0; i< marks.length; i++) {
            System.out.println(marks[i]);
        }

        System.out.println("---------------------");

        for(int i =0; i< intMarks.length; i++) {
            System.out.println(intMarks[i]);
        }


    }

    public void m2(int size){
        int[] num = new int[size];
        for (int i =0; i<size; i++) {
            num[i] = (i+1)*10;
        }

        for (int i =0; i<size; i++) {
            System.out.println(num[i]);
        }



    }

    public static void main(String[] args) {

      ArrayDemo d1 = new ArrayDemo();
      d1.custom2dArray();




    }
}
