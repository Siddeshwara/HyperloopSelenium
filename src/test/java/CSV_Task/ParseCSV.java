package CSV_Task;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.StringTokenizer;

public class ParseCSV {

    public static void main(String[] args) {


            //csv file containing data
            String csvFile = "C:\\SeleniumTraining\\testit.csv";

            //create BufferedReader to read csv file
            try {
                //csv file containing data
                CSVReader reader = new CSVReader(new FileReader(csvFile));
                String[] allChannels = new String[] {"RTL_HD-video","Das_Erste_HD-video","ZDF_HD-video"};
                String[] columnNumber;
                String columnTime;
                String columnChannel;
                String rtlChannel;
                String zdfChannel;

                while ((columnNumber = reader.readNext()) != null) {
                    columnTime = columnNumber[1];
                    columnChannel = columnNumber[6];

                    for (String channel : allChannels) {
                        //System.out.println(channel);
                        //columnChannel.contains(channel);
                        System.out.println(columnNumber[6].contains(channel));
                        if(columnNumber[6].contains(channel))
                        {

                        }

                    }

                }
            }

            catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }
        }
    }
