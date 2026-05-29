package se.iths.martin.emailserviceprojekt2.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItem {
    private String name;
    private BigDecimal price;
    private int quantity;
}
