package com.base_java.baselts.repository;

import com.base_java.baselts.entity.ContractAppendix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractAppendixRepository extends JpaRepository<ContractAppendix,String> {
}
