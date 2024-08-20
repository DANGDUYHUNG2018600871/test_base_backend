package com.base_java.baselts.entity;

import com.base_java.baselts.enums.ContractStatus;
import com.base_java.baselts.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    LocalDate dateOfBirth;
    String fullName;
    String avatarUrl;
    String username;
    String password;

    //luu gia tri so trong csdl
    @Enumerated(EnumType.ORDINAL)
    Gender gender;
    String normalizedUserName;
    String email;
    String normalizedEmail;
    boolean emailConfirmed;
    String securityStamp;
    String concurrencyStamp;
    String phoneNumber;
    boolean phoneNumberConfirmed;
    boolean twoFactorEnabled;
    LocalDate lockoutEnd;
    boolean lockoutEnabled;
    boolean accessFailedCout;
    boolean isDeleted;

    // de role cua user dk tai cung luc voi viec truy van database
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<RefreshToken> refreshTokens;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Notification> notifications;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Contract> contracts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Payroll>payrolls;

    @ManyToOne
    Position position;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<ConfirmEmail> confirmEmails;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Department>departments;
}
