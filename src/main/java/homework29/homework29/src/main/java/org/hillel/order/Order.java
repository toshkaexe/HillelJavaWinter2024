package org.hillel.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
    private int id;
    private String date;
    private double cost;
    private List<Product> products;

}
