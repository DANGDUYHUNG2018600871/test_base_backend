package com.base_java.baselts.mapper;

import com.base_java.baselts.dto.request.request_department.DepartmentCreationRequest;
import com.base_java.baselts.dto.request.request_department.DepartmentUpdateRequest;
import com.base_java.baselts.dto.response.response_department.DepartmentResponse;
import com.base_java.baselts.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toDepartment(DepartmentCreationRequest request);
    DepartmentResponse toDepartmentResponse(Department department);
//    @Mapping(ignore = true)
    void updateDepartment(@MappingTarget Department department, DepartmentUpdateRequest request);
}
