package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{

}
