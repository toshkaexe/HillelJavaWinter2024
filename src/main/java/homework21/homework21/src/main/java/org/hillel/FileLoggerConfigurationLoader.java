package org.hillel;

import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) throws IOException {
        // Logic to load configuration from file
        // Example: read configuration from file and parse it
        String[] lines = { // Dummy data, replace with actual file reading logic
                "FILE: logs.txt",
                "LEVEL: DEBUG",
                "MAX-SIZE: 1024",
                "FORMAT: [TIME] [LEVEL] Message: [MESSAGE]"
        };

        String logFilePath = "";
        LoggingLevel level = null;
        long maxSize = 0;
        String format = "";

        for (String line : lines) {
            String[] parts = line.split(": ");
            switch (parts[0]) {
                case "FILE":
                    logFilePath = parts[1];
                    break;
                case "LEVEL":
                    level = LoggingLevel.valueOf(parts[1]);
                    break;
                case "MAX-SIZE":
                    maxSize = Long.parseLong(parts[1]);
                    break;
                case "FORMAT":
                    format = parts[1];
                    break;
            }
        }

        return new FileLoggerConfiguration(logFilePath, level, maxSize, format);
    }
}
