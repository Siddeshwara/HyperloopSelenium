package Selenium_Commands;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Lab18_ReadExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream file=new FileInputStream("C:\\SeleniumTraining\\Data.xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook(file);

        XSSFSheet sheet=workbook.getSheet("S1");


        int rownum=sheet.getLastRowNum(); // returns number of rows present in excel sheet
        int colcount=sheet.getRow(0).getLastCellNum(); // returns number of cells present in a row

        System.out.println("Row number:" + rownum );
        System.out.println("Column number :" + colcount );

        for(int i=0;i<=rownum;i++) //rownum = 3 , i++ = 1
        {
            XSSFRow row=sheet.getRow(i);

            for(int j=0;j<colcount;j++) // j++ = 1
            {
                DataFormatter formatter = new DataFormatter();
                String cellData = formatter.formatCellValue(row.getCell(j));
                System.out.print(cellData+" ");

            }

            System.out.println();

        }

    }

}
