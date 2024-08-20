package com.base_java.baselts.service.impl;

import com.base_java.baselts.dto.request.request_department.DepartmentCreationRequest;
import com.base_java.baselts.dto.request.request_department.DepartmentUpdateRequest;
import com.base_java.baselts.dto.response.PageResponse;
import com.base_java.baselts.dto.response.response_department.DepartmentResponse;
import com.base_java.baselts.entity.Department;
import com.base_java.baselts.exception.AppException;
import com.base_java.baselts.exception.ErrorCode;
import com.base_java.baselts.mapper.DepartmentMapper;
import com.base_java.baselts.repository.DepartmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService {
    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    public DepartmentResponse createDepartment(DepartmentCreationRequest request){
        request.setCreateTime(LocalDate.now());
        Department department=departmentMapper.toDepartment(request);
        try {
            department=departmentRepository.save(department);
        }catch (DataIntegrityViolationException exception){
            throw new AppException(ErrorCode.DEPARTMENT_INVALID);
        }
        return departmentMapper.toDepartmentResponse(department);
    }

    public DepartmentResponse updateDepartment(String departmentId, DepartmentUpdateRequest request){
        Department department=departmentRepository.findById(departmentId).orElseThrow(()->new AppException(ErrorCode.DEPARTMENT_INVALID));
        departmentMapper.updateDepartment(department,request);

        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }

    public void deleteDepartment(String departmentId){
        departmentRepository.deleteById(departmentId);
    }

    public DepartmentResponse getDepartment(String id){
        return departmentMapper.toDepartmentResponse(departmentRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.DEPARTMENT_INVALID)));
    }
    @PreAuthorize("hasRole('ADMIN')")
    public PageResponse<DepartmentResponse> getAllDepartment(int page,int size){
        Sort sort=Sort.by("createTime").descending();
        Pageable pageable= PageRequest.of(page-1,size, sort);
        var pageData=departmentRepository.findAll(pageable);
        return PageResponse.<DepartmentResponse>builder()
                .currentPage(page)
                .pageSize(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream()
                        .map(departmentMapper::toDepartmentResponse)
                        .toList())
                .build();
    }
}
