package com.lab.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lab.dto.StudentDTO;


public interface IStudentService {
	StudentDTO insert(StudentDTO studentDTO);
	List<StudentDTO> findAll(Pageable pageable);
	Integer getTotalItem();
	List<StudentDTO> searchStudentByKeyword(String query);
	StudentDTO findByID(Long studentIdCard);
	List<StudentDTO> searchStudentDetailsByKeyword(String search);
}
