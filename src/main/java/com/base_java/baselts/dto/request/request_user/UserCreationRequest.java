package com.base_java.baselts.dto.request.request_user;

import com.base_java.baselts.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3,message = "USERNAME_INVALID")
    String username;

    @Size(min = 3, message = "INVALID_PASSWORD")
    String password;
    String fullName;
    String avatarUrl;

    @DobConstraint(min = 10, message = "INVALID_DOB")
    LocalDate dateOfBirth;
}