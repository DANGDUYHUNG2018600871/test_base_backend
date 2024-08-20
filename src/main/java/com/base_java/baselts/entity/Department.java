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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(name="name",unique = true,columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String name;
    String Slogan;
    Integer numberOfMember;
    LocalDate createTime;
    LocalDate updateTime;
    @Column(insertable=false, updatable=false)
    String managerId;
    @ManyToOne
    @JoinColumn(name="managerId")
    User user;
}
