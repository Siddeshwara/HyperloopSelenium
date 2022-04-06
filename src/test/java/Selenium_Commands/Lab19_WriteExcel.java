package Selenium_Commands;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab19_WriteExcel {

    public static void main(String[] args) throws IOException {

        FileOutputStream file=new FileOutputStream("C:\\SeleniumTraining\\testdata.xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook();

        XSSFSheet sheet=workbook.createSheet("data");

        for(int i=0;i<=5;i++) //rows 0, 1, 2, 3, 4,5
        {
            XSSFRow row=sheet.createRow(i);

            for(int j=0;j<=3;j++) //cells/columns 0, 1, 2
            {
                row.createCell(j).setCellValue("ABCD");
            }
        }


        workbook.write(file);

        System.out.println("writing excel is completed");

    }

}
