package com.example.springdemo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "credit_applications",
    schema = "flyway_training"
)
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    @Column(name = "tenor_month")
    private Integer tenorMonth;

    @Column(name = "status")
    private String status;

    @Column(
        name = "created_at",
        insertable = false,
        updatable = false
    )
private LocalDateTime createdAt;
}
