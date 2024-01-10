package com.lab.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lab.dto.SchoolDTO;

public interface ISchoolService {
	SchoolDTO insert(SchoolDTO schoolDTO);
	List<SchoolDTO> findAll(Pageable pageable);
	Integer getTotalItem();
	SchoolDTO findByID(Integer schoolId);
}
