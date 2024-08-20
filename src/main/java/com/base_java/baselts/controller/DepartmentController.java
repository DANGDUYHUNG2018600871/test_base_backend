package com.base_java.baselts.controller;

import com.base_java.baselts.dto.request.request_department.DepartmentCreationRequest;
import com.base_java.baselts.dto.request.request_department.DepartmentUpdateRequest;
import com.base_java.baselts.dto.response.ApiResponse;
import com.base_java.baselts.dto.response.PageResponse;
import com.base_java.baselts.dto.response.response_department.DepartmentResponse;
import com.base_java.baselts.service.impl.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {
    DepartmentService departmentService;
    @PostMapping
    ApiResponse<DepartmentResponse> createDepartment(@RequestBody @Valid DepartmentCreationRequest request){
        return ApiResponse.<DepartmentResponse>builder()
                .result(departmentService.createDepartment(request))
                .build();
    }
    @PutMapping("/{departmentId}")
    ApiResponse<DepartmentResponse>updateDepartment(@PathVariable String departmentId, @RequestBody DepartmentUpdateRequest request){
        return ApiResponse.<DepartmentResponse>builder()
                .result(departmentService.updateDepartment(departmentId,request))
                .build();
    }
    @DeleteMapping("/{departmentId}")
    ApiResponse<String> deleteDepartment(@PathVariable String departmentId){
        return ApiResponse.<String>builder()
                .result("Department has beeen deleted")
                .build();
    }
    @GetMapping("/{departmentId}")
    ApiResponse<DepartmentResponse>getDepartment(@PathVariable("departmentId") String departmentId){
        return ApiResponse.<DepartmentResponse>builder()
                .result(departmentService.getDepartment(departmentId))
                .build();
    }
    @GetMapping()
    ApiResponse<PageResponse<DepartmentResponse>> getAllDepartment(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                   @RequestParam(value = "size",required = false,defaultValue = "10")int size){
        return ApiResponse.<PageResponse<DepartmentResponse>>builder()
                .result(departmentService.getAllDepartment(page,size))
                .build();
    }
}
