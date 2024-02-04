package org.hillel;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testGetExpensiveBooks() {
        List<Product> products = Arrays.asList(
                new Product("Book", 300),
                new Product("Book", 200),
                new Product("Toy", 300)
        );

        List<Product> expensiveBooks = Product.getExpensiveBooks(products);

        assertEquals(1, expensiveBooks.size());
        assertEquals(300, expensiveBooks.get(0).getPrice());
    }

    @Test
    public void testGetDiscountedBooks() {
        List<Product> products = Arrays.asList(
                new Product("Book", 300, true),
                new Product("Book", 200, false),
                new Product("Toy", 300, true)
        );

        List<Product> discountedBooks = Product.getDiscountedBooks(products);

        assertEquals(1, discountedBooks.size());
        assertEquals(270, discountedBooks.get(0).getPrice());
    }

    @Test
    public void testGetCheapestBook() {
        List<Product> products = Arrays.asList(
                new Product("Book", 300),
                new Product("Book", 200),
                new Product("Toy", 400)
        );

        Product cheapestBook = Product.getCheapestBook(products);

        assertEquals(200, cheapestBook.getPrice());
    }

    @Test
    public void testCalculateTotalCost() {
        List<Product> products = Arrays.asList(
                new Product("Book", 50, LocalDateTime.now()),
                new Product("Book", 70, LocalDateTime.now()),
                new Product("Toy", 80, LocalDateTime.now())
        );

        double totalCost = Product.calculateTotalCost(products);

        assertEquals(120, totalCost);
    }

    @Test
    public void testGroupProductsByType() {
        List<Product> products = Arrays.asList(
                new Product("Book", 50),
                new Product("Book", 70),
                new Product("Toy", 80)
        );

        Map<String, List<Product>> groupedProducts = Product.groupProductsByType(products);

        assertEquals(2, groupedProducts.size());
        assertTrue(groupedProducts.containsKey("Book"));
        assertTrue(groupedProducts.containsKey("Toy"));
    }
}
