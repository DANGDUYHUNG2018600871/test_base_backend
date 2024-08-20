package com.base_java.baselts.entity;

import com.base_java.baselts.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String code;
    int contractTypeld;
    String content;
    LocalDate startDate;
    LocalDate endDate;
    float baseSalary;
    float salaryBeforeTax;

    //luu gia tri so trong csdl
    @Enumerated(EnumType.ORDINAL)
    ContractStatus status;

    float taxPercentage;
    String signatureA;
    String signatureB;
    boolean isSubsidized;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "contract")
    Set<ContractAllowance> contractAllowances;

    @OneToMany(mappedBy = "contract")
    Set<ContractAppendix> contractAppendices;

    @OneToMany(mappedBy = "contract")
    Set<ContractHistory> contractHistories;

    @ManyToOne
    ContractType contractType;
}
