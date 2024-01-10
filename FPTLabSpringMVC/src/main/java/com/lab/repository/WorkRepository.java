package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.WorkEntity;
@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Integer> {

}
