package com.base_java.baselts.dto.request.request_user;

import com.base_java.baselts.validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String fullName;
    String avatarUrl;
    List<String> roles;
    @DobConstraint(min=18,message = "INVALID_DOB")
    LocalDate dateOfBirth;
}