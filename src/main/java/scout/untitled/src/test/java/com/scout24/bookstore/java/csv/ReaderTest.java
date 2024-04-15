package com.scout24.bookstore.java.csv;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderTest {

  private final Reader reader = new Reader();

  @Test
  void shouldReadAllRecordsInCsvFile() throws IOException, URISyntaxException {
    var path = givenCsvFilePath();
    var expectedFirstRecord = givenFirstRecord();
    var expectedSecondRecord = givenSecondRecord();

    var records = whenReadingCsvFile(path);
    var iterator = records.iterator();

    thenNumberOfReadRecordsMatchesExpectation(2L, records.size());
    thenRecordMatchesExpectation(expectedFirstRecord, iterator.next());
    thenRecordMatchesExpectation(expectedSecondRecord, iterator.next());
  }

  private Path givenCsvFilePath() throws URISyntaxException {
    return Paths.get(
      Objects.requireNonNull(this.getClass().getClassLoader().getResource("disney.csv")).toURI()
    );
  }

  private Map<String, String> givenFirstRecord() {
    return Map.of(
      "author", "Sir Quackalot",
      "format", "paperback",
      "id", "1",
      "price", "10.99",
      "title", "The Adventures of Duck and Goose"
    );
  }

  private Map<String, String> givenSecondRecord() {
    return Map.of(
      "author", "Sir Quackalot",
      "format", "paperback",
      "id", "2",
      "price", "19.99",
      "title", "The Return of Duck and Goose"
    );
  }

  private List<Map<String, String>> whenReadingCsvFile(Path filePath) throws IOException {
    return reader.read(filePath, item -> item);
  }

  @SuppressWarnings("SameParameterValue")
  private void thenNumberOfReadRecordsMatchesExpectation(long expected, long numberOfRecords) {
    assertEquals(expected, numberOfRecords);
  }

  private void thenRecordMatchesExpectation(Map<String, String> expected, Map<String, String> readRecord) {
    assertEquals(expected.get("author"), readRecord.get("author"));
    assertEquals(expected.get("format"), readRecord.get("format"));
    assertEquals(expected.get("id"), readRecord.get("id"));
    assertEquals(expected.get("price"), readRecord.get("price"));
    assertEquals(expected.get("title"), readRecord.get("title"));
  }
}
