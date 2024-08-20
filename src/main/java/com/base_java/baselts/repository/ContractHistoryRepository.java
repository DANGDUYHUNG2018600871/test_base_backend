package com.base_java.baselts.repository;

import com.base_java.baselts.entity.ContractHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractHistoryRepository extends JpaRepository<ContractHistory,String> {
}

