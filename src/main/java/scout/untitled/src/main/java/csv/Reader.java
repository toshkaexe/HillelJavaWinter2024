package java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Reader {

  public <T> List<T> read(Path csvFilePath, RowMapper<T> rowMapper) throws IOException {
    try (
      var parser = CSVParser.parse(
        Files.newInputStream(csvFilePath),
        UTF_8,
        CSVFormat.DEFAULT.builder()
          .setHeader()
          .setSkipHeaderRecord(true)
          .setIgnoreHeaderCase(true)
          .setTrim(true)
          .build()
      )
    ) {
      return parser.stream()
        .map(row -> rowMapper.apply(row.toMap()))
        .toList();
    }
  }

  @FunctionalInterface
  public interface RowMapper<T> {
    T apply(Map<String, String> row);
  }
}
