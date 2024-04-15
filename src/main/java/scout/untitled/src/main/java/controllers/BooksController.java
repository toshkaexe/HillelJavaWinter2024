package java.controllers;

import java.services.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
class BooksController {

  private final BooksService booksService;

  public BooksController(BooksService booksService) {
    this.booksService = booksService;
  }

  @GetMapping("/books")
  public List<Object> books(@RequestParam(required = false) Map<String, String> queryParams) {
    log.info("Get books call received with query params $queryParams");
    return new ArrayList<>();
  }
}
