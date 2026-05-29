package se.iths.martin.emailserviceprojekt2.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private LocalDateTime orderDate;
    private String customerName;
    private List<OrderItem> orderItems;
    private BigDecimal totalPrice;
}
