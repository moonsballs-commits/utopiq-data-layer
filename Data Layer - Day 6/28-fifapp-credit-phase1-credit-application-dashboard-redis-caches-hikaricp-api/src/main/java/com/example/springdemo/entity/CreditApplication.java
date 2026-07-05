package com.example.springdemo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "branch_id")
    private Long branchId;

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
