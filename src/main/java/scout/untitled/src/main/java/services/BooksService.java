package java.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

  public List<Object> unique() {
    return List.of();
  }

  public List<Object> orderBy(String title, String height) {
    return List.of();
  }

  public List<Object> findBy(String author, String genre) {
    return List.of();
  }
}
