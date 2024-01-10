package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.dto.GraduateDTO;
import com.lab.entity.GraduateEntity;
@Repository
public interface GraduateRepository extends JpaRepository<GraduateEntity, Integer>{

}
