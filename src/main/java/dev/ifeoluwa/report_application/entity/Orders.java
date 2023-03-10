package dev.ifeoluwa.report_application.entity;

import dev.ifeoluwa.report_application.dto.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author on 09/03/2023
 * @project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID orderId;
    private Long productId;
    private int quantity;
    private Double totalPrice;
    @Transient
    private Customer customer;
    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();
}
