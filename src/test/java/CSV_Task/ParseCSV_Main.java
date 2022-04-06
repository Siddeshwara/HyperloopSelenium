
package CSV_Task;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.time.format.DateTimeFormatter;


public class ParseCSV_Main {

    public static void main(String[] args) throws ParseException {

        // csv file containing data
        String csvFile = "testit1.csv";

        // create BufferedReader to read csv file
        try {
            // csv file containing data
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] allChannels = new String[] { "ZDF_HD-video", "RTL_HD-video", "Das_Erste_HD-video" };
            String[] columnNumber;
            String columnTime;
            String columnChannel;
            String rtlChannel;
            String zdfChannel;

            List<String[]> allData = reader.readAll();
            String[] previousChannelData = null;
            List<String[]> listToWriteIntoCsv = new ArrayList<>();
            String[] header = { "Channel", "Time before switch", "Next Channel", "Time after switch",
                    "Time Difference in seconds" };
            listToWriteIntoCsv.add(header);
            for (String channel : allChannels) {
                // print Data

                for (int i = 1; i < allData.size(); i++) {
                    String[] row = allData.get(i);

                    columnTime = row[1];
                    columnChannel = row[6];

                    if (previousChannelData == null)
                        previousChannelData = row;
                    if (!row[6].contains(channel)) {
                        continue;
                    }
                    if (previousChannelData[6].contains(channel) && row[6].contains(channel)) {
                        previousChannelData = row;
                    } else {
                        System.out.println(previousChannelData[6]);
                        System.out.println(row[6]);

                        //DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").parse(previousChannelData[1].substring(0, 22);

                        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(previousChannelData[1].split(",")[0].substring(0, 19));
                        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(previousChannelData[1].substring(0, 23));
                        Date date11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(previousChannelData[1]);
                        System.out.println(date1);
                        System.out.println(previousChannelData[1].substring(0, 23));

                        //Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row[1].split(",")[0].substring(0, 19));
                        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row[1].substring(0, 22));
                        System.out.println(date2);

                        String timeDifference = String.valueOf(((date2.getTime() - date1.getTime()) / 1000) % 60);
                        System.out.println(timeDifference);

                        String[] records = {
                                previousChannelData[6],
                                date1.toString(),
                                row[6],
                                date2.toString(),
                                timeDifference
                        };
                        listToWriteIntoCsv.add(records);
                        break;
                    }
                }

            }

            try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
                writer.writeAll(listToWriteIntoCsv);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
