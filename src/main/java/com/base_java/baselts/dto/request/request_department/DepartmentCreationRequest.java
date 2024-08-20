package com.base_java.baselts.dto.request.request_department;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreationRequest {
    @Size(min = 3,message = "DEPARTMENT_INVALID")
    String name;
    String slogan;
    Integer numberOfMember=0;
    String managerId;
    LocalDate createTime;
}
