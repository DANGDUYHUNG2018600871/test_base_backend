package com.base_java.baselts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String confirmCode;
    String createTime;
    LocalDate expiredTime;
    boolean isConfirmed;

    @ManyToOne
    User user;
}
