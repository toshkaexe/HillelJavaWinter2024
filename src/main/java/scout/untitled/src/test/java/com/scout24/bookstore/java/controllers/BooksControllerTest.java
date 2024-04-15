package com.scout24.bookstore.java.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest {

  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private MockMvc mvc;

  @Test
  @Disabled
  void shouldReturnAllBooksWithoutDuplicates() throws Exception {
    var result = mvc.perform(get("/api/books")).andExpect(status().isOk()).andReturn();
    var jsonNode = objectMapper.readTree(result.getResponse().getContentAsString());

    assertTrue(jsonNode.isArray());
    assertEquals(4, jsonNode.size());
  }

  @Test
  @Disabled
  void shouldReturnAllBooksSortedDescByTitle() throws Exception {
    var result = mvc.perform(get("/api/books?sort=title:desc")).andExpect(status().isOk()).andReturn();
    var jsonNode = objectMapper.readTree(result.getResponse().getContentAsString());
    var sortedBookTitles = StreamSupport.stream(jsonNode.spliterator(), false)
      .map(node -> node.get("title").textValue())
      .toList();

    assertTrue(jsonNode.isArray());
    assertEquals(
      List.of(
        "The Return of Duck and Goose",
        "The Adventures of Duck and Goose",
        "Nature of Statistical Learning Theory, The",
        "Fundamentals of Wavelets"
      ),
      sortedBookTitles
    );
  }

  @Test
  @Disabled
  void shouldReturnAllBooksSortedAscByHeight() throws Exception {
    var result = mvc.perform(get("/api/books?sort=height:asc")).andExpect(status().isOk()).andReturn();
    var jsonNode = objectMapper.readTree(result.getResponse().getContentAsString());
    var sortedBookHeights = StreamSupport.stream(jsonNode.spliterator(), false)
      .map(node -> node.get("height").longValue())
      .toList();

    assertTrue(jsonNode.isArray());
    assertEquals(List.of(50L, 228L, 230L), sortedBookHeights);
  }

  @Test
  @Disabled
  void shouldReturnAllBooksWithTheGenreDataScience() throws Exception {
    var result = mvc.perform(get("/api/books?q=genre:data_science")).andExpect(status().isOk()).andReturn();
    var jsonNode = objectMapper.readTree(result.getResponse().getContentAsString());
    var queriedBookTitles = StreamSupport.stream(jsonNode.spliterator(), false)
      .map(node -> node.get("title").textValue())
      .toList();

    assertTrue(jsonNode.isArray());
    assertEquals(
      List.of("Nature of Statistical Learning Theory, The", "The Return of Duck and Goose"),
      queriedBookTitles
    );
  }
}
