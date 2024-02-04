package org.hillel;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Getter
@Setter
public class Product {

    String type;
    double price;
    boolean discount;
    LocalDateTime createDate;
    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean isDiscount) {
        this.type = type;
        this.price = price;
        this.discount = isDiscount;
    }

    public Product(String type, double price, LocalDateTime createDate) {
        this.type = type;
        this.price = price;
        this.createDate = createDate;
    }

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(p -> "Book".equals(p.type) && p.price > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(p -> "Book".equals(p.type) && p.discount)
                .map(p -> {
                    p.price *= 0.9; // застосування знижки 10%
                    return p;
                })
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(p -> "Book".equals(p.type))
                .min((p1, p2) -> Double.compare(p1.price, p2.price))
                .orElseThrow(() ->
                 new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLatestProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        return products.stream()
                .filter(p -> "Book".equals(p.type)
                        && p.createDate.getYear() == LocalDate.now().getYear()
                        && p.price <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}