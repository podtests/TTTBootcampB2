package in.podtest.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    //
    public static String[][] readDataFromExcelFile(String filePath) {

        File file = new File(filePath);  //converting file into an object
        FileInputStream fileInputStream = null;
        XSSFWorkbook xssfWorkbook = null;

        try {
            fileInputStream  = new FileInputStream(file); ///sets a connection to read content as Bytes
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sheet= xssfWorkbook.getSheet("Data");
        int lastRowNum = sheet.getLastRowNum(); //2  [zero index based]
        System.out.println("lastRowNum is:"+lastRowNum);  //2 [0,1,2]

        XSSFRow row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();  //2  [1 index based]  [1,2]

        //2*2
        String[][] data = new String[lastRowNum][lastColumnNum];



        System.out.println("lastColumnNum is:"+lastColumnNum);

//2*2
        /*
        {
               { (0,0) , (0,1) }
               {  (1,0), (1,1)  }
        }
        */

        for(int i = 1; i <=lastRowNum; i++) {
            for(int j =0; j < lastColumnNum; j++) {  //[0,1]

                //excel:
                data[i-1][j]  = sheet.getRow(i).getCell(j).toString();

                //System.out.print(sheet.getRow(i).getCell(j).toString() + " ");  //get cell works on 0 based[0,1]
            }
            //System.out.println();
        }

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j< data[i].length; j++) {
                System.out.print(data[i][j]+ " ");
            }
            System.out.println();
        }


        try {
            xssfWorkbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
