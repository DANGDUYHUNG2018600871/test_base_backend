package com.base_java.baselts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    BigDecimal salaryCoefficient;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    Set<User> users;

}
