package com.base_java.baselts.repository;

import com.base_java.baselts.entity.ContractAllowance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractAllowanceRepository extends JpaRepository<ContractAllowance,String> {
}
