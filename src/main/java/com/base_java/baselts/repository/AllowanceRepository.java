package com.base_java.baselts.repository;

import com.base_java.baselts.entity.Allowance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance, String> {
}
