package com.base_java.baselts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ContractAppendix {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    LocalDate appendixDate;

    //JPA ánh xạ trong csdl no la text
    @Column(columnDefinition = "TEXT")
    String details;

    @ManyToOne
    Contract contract;
}
