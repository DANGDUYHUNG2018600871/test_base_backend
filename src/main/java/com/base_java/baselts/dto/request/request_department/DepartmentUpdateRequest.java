package com.base_java.baselts.dto.request.request_department;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentUpdateRequest {
    String name;
    String slogan;
    Integer numberOfMember;
    String managerId;
    LocalDate updateTime;
}
