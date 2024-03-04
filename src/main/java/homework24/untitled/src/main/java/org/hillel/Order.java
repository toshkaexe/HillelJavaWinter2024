package org.hillel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Integer id;
    private Date date;
    private double cost;
    private List<Product> products;


}
