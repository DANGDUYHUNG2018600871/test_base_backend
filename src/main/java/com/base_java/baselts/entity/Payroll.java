package com.base_java.baselts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    BigDecimal baseSalary;
    BigDecimal overtimeSalary;
    BigDecimal allowanceSalary;
    BigDecimal productivitySalary;
    BigDecimal otherIncome;
    BigDecimal totalSalary;
    Integer month;
    Integer year;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    User user;
}
