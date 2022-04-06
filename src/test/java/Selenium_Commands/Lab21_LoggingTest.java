package Selenium_Commands;
//Steps to be done
// 1) Right click on Project--> New -->Source Folder-->resources
// 2) Place log4j2.properties in resources folder

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lab21_LoggingTest {

    public static void main(String[] args) {

        Logger logger=LogManager.getLogger();

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        System.out.println("Hello World...");

    }

}
