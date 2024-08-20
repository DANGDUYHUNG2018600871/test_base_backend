package com.base_java.baselts.repository;

import com.base_java.baselts.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    boolean existsByName(String name);
    Page<Department> findAll(Pageable pageable);
}
