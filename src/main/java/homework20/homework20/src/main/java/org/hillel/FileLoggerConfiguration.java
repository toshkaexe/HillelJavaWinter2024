package org.hillel;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }
}
