package com.base_java.baselts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Allowance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String allowanceName;
    float amount;

    @OneToMany(mappedBy = "allowance")
    Set<ContractAllowance> contractAllowances;
}
