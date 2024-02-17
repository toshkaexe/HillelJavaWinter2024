package org.hillel;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoggerTest {
    @Test
    void testLoggingINFOlevel() throws IOException, FileMaxSizeReachedException {
        String logFilePath = "configTest.txt";
        FileLoggerConfiguration config = new FileLoggerConfiguration(logFilePath,
                LoggingLevel.INFO,
                500000,
                "[TIME][LEVEL] Message: [MESSAGE]");
        FileLogger logger = new FileLogger(config);

        // Write a log message
        logger.info("Test info log message");

        // Check if the log file is created
        File logFile = new File(logFilePath);
        assertTrue(logFile.exists());

        // read list line from the file
        String line = readLastLineFromFile(logFilePath);
        // pattern regex
        String regexPattern = "\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\]\\[INFO\\] Message: .+";
        boolean isMatch = Pattern.matches(regexPattern, line);
        assertTrue(isMatch);

    }


    @Test
    void testLoggingDEBUGlevel() throws IOException, FileMaxSizeReachedException {
        String logFilePath = "configTest.txt";
        FileLoggerConfiguration config = new FileLoggerConfiguration(logFilePath,
                LoggingLevel.DEBUG,
                500000,
                "[TIME][LEVEL] Message: [MESSAGE]");
        FileLogger logger = new FileLogger(config);

        // Write a log message
        logger.debug("Test info log message");
        // Check if the log file is created
        File logFile = new File(logFilePath);
        assertTrue(logFile.exists());

        // read list line from the file
        String line = readLastLineFromFile(logFilePath);

        // pattern regex
        String regexPattern = "\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\]\\[DEBUG\\] Message: .+";
        boolean isMatch = Pattern.matches(regexPattern, line);
        assertTrue(isMatch);

    }

    public static String readLastLineFromFile(String filePath) {
        String lastLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }
}