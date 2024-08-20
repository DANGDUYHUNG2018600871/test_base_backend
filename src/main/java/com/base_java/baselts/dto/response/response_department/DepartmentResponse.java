package com.base_java.baselts.dto.response.response_department;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponse {
    String id;
    String name;
    String slogan;
    Integer numberOfMember;
    String managerId;
    LocalDate createTime;
    LocalDate updateTime;
}
