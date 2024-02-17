package org.hillel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message) throws IOException, FileMaxSizeReachedException {
        log(LoggingLevel.DEBUG, message);
    }

    public void info(String message) throws IOException, FileMaxSizeReachedException {
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel level, String message) throws IOException, FileMaxSizeReachedException {
        if (level.ordinal() <= config.getLoggingLevel().ordinal()) {
            String logMessage = config.getFormat()
                    .replace("[TIME]", getCurrentTime())
                    .replace("[LEVEL]", level.toString())
                    .replace("[MESSAGE]", message);

            File logFile = new File(config.getFilePath());
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            if (logFile.length() + logMessage.length() > config.getMaxSize()) {
                throw new FileMaxSizeReachedException("Maximum file size reached.");
            }

            try (FileWriter writer = new FileWriter(logFile, true)) {
                writer.write(logMessage + "\n");
            }
        }
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
